package net.saltedgrove.refrigerator.service

import net.saltedgrove.refrigerator.domain.AggregateItem
import net.saltedgrove.refrigerator.domain.Item
import net.saltedgrove.refrigerator.domain.Refrigerator
import net.saltedgrove.refrigerator.domain.data.ItemKey
import net.saltedgrove.refrigerator.domain.data.ItemRow
import net.saltedgrove.refrigerator.domain.data.RefrigeratorKey
import net.saltedgrove.refrigerator.domain.data.RefrigeratorRow
import net.saltedgrove.refrigerator.repositories.ItemRepository
import net.saltedgrove.refrigerator.repositories.RefrigeratorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RefrigeratorService(@Autowired val refrigeratorRepository: RefrigeratorRepository,
                          @Autowired val itemRepository: ItemRepository,
                          @Autowired val rulesService: RulesService){
    fun createRefrigerator(refrigerator: Refrigerator){
        refrigeratorRepository.save(RefrigeratorRow(refrigerator))
        refrigerator.items.forEach{aggregateItem -> addItemToRefrigerator(aggregateItem.toItem(refrigerator.toKey()))}
    }
    fun deleteRefrigerator(ownerName: String, name : String){
        refrigeratorRepository.deleteById(RefrigeratorKey(name = name, ownerName = ownerName))
    }
    fun getRefrigerator(ownerName : String, name : String) : Refrigerator?{
        var refrigeratorRow: RefrigeratorRow? = refrigeratorRepository.findByIdOrNull(RefrigeratorKey(name = name, ownerName = ownerName))
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find associated refrigerator")
        var items = itemRepository.findByRefrigerator(ownerName, name).map { ref -> AggregateItem(ref) }
        return Refrigerator(refrigeratorRow, items)
    }
    fun addItemToRefrigerator(item : Item){
        if(item.count <= 0){
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Item count must be > 0")
        }
        refrigeratorRepository.findByIdOrNull(RefrigeratorKey(item.refrigeratorKey.name!!, item.refrigeratorKey.ownerName!!))
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find associated refrigerator")
        var findItem : ItemRow? = itemRepository.findByIdOrNull(ItemKey(item))
        if (findItem == null){
            itemRepository.save(ItemRow(item))
        } else {
            rulesService.checkCount(item)
            findItem.count = findItem.count?.plus(item.count)
            itemRepository.save(findItem)
        }
    }
    fun updateItem(oldItemKey : ItemKey, newItem : Item){
        itemRepository.deleteById(oldItemKey)
        itemRepository.save(ItemRow(newItem))
    }
    fun deleteItem(item : ItemKey){
        itemRepository.deleteById(item)
    }
}