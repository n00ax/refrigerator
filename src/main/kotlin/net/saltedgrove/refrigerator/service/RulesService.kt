package net.saltedgrove.refrigerator.service

import net.saltedgrove.refrigerator.domain.BuiltInCategory
import net.saltedgrove.refrigerator.domain.Item
import net.saltedgrove.refrigerator.repositories.ItemRepository
import net.saltedgrove.refrigerator.rules.MAX_CAN_COUNT
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class RulesService(val itemRepository: ItemRepository) {
    fun checkCount(item: Item) {
        if (itemRepository.getBuiltInCategoryCount(item.refrigeratorKey.name, item.refrigeratorKey.ownerName,
                        BuiltInCategory.SODA_CAN.toString()) >= 12) {
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Soda Can limit exceeded, max = $MAX_CAN_COUNT")
        }
    }
}