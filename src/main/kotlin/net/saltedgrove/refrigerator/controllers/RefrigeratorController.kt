package net.saltedgrove.refrigerator.controllers

import net.saltedgrove.refrigerator.domain.Item
import net.saltedgrove.refrigerator.domain.Refrigerator
import net.saltedgrove.refrigerator.domain.data.ItemKey
import net.saltedgrove.refrigerator.service.RefrigeratorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController("/")
class RefrigeratorController(@Autowired val refrigeratorService : RefrigeratorService){
    @GetMapping("refrigerator")
    fun getRefrigerator(ownerName : String, name : String) : Refrigerator?{
        return refrigeratorService.getRefrigerator(ownerName, name)
    }
    @PostMapping("refrigerator")
    fun postRefrigerator(@RequestBody refrigerator: Refrigerator){
        refrigeratorService.createRefrigerator(refrigerator)
    }
    @DeleteMapping("refrigerator")
    fun deleteRefrigerator(ownerName: String, name : String){
        refrigeratorService.deleteRefrigerator(ownerName, name)
    }
    @PostMapping("item")
    fun postItem(@RequestBody item: Item){
        refrigeratorService.addItemToRefrigerator(item)
    }
    @DeleteMapping("item")
    fun deleteItem(item : ItemKey){
        refrigeratorService.deleteItem(item)
    }
}