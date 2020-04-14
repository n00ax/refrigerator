package net.saltedgrove.refrigerator

import net.saltedgrove.refrigerator.controllers.RefrigeratorController
import net.saltedgrove.refrigerator.domain.AggregateItem
import net.saltedgrove.refrigerator.domain.BuiltInCategory
import net.saltedgrove.refrigerator.domain.Refrigerator
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import java.time.ZonedDateTime

@SpringBootTest
class ControllerTests(val refrigeratorController: RefrigeratorController){
    var testItem1 = AggregateItem(name = "Coca Cola", description = "Drink Refreshing Coca Cola", expiry = ZonedDateTime.now(),
            count = 1, builtInCategory = BuiltInCategory.SODA_CAN, category = "COKE")
    var testItem3 = AggregateItem(name = "Water", description = "Cool and Refreshing", expiry = ZonedDateTime.now(),
            count = 1, builtInCategory = BuiltInCategory.OTHER, category = "WATER")
    var testItem4 = AggregateItem(name = "Dr. Pepper", description = "It's Good!", expiry = ZonedDateTime.now(),
            count = 1, builtInCategory = BuiltInCategory.SODA_CAN, category = "SODA")
    var testItem5 = AggregateItem(name = "Dr. Pepper", description = "It's Good! 2", expiry = ZonedDateTime.now(),
            count = 11, builtInCategory = BuiltInCategory.SODA_CAN, category = "SODA")
    var referenceFridge1 = Refrigerator("fridge-1", "John Doe", listOf(testItem1))
    var referenceFridge2 = Refrigerator("fridge-2", "Jane Doe", listOf(testItem1, testItem3))
    var referenceFridge3 = Refrigerator("fridge-1", "Kim Doe", listOf(testItem1, testItem4, testItem5))
    @Test
    fun createRefrigeratorBasic(){
        refrigeratorController.postRefrigerator(referenceFridge1)
        var getRefrigerators = refrigeratorController.getRefrigerator(referenceFridge1.name, referenceFridge1.ownerName)
        Assertions.assertEquals(referenceFridge1, getRefrigerators)
    }
    @Test
    fun createRefrigeratorOther(){
        refrigeratorController.postRefrigerator(referenceFridge2)
        var getRefrigerators = refrigeratorController.getRefrigerator(referenceFridge2.name, referenceFridge2.ownerName)
        Assertions.assertEquals(referenceFridge2, getRefrigerators)
    }
    @Test
    fun createRefrigeratorSodaCanLimit(){
        refrigeratorController.postRefrigerator(referenceFridge3)
        try{
            refrigeratorController.getRefrigerator(referenceFridge3.name, referenceFridge3.ownerName)
            assert(false)
        } catch (e : ResponseStatusException) {
        }
    }
    @Test
    fun deleteRefrigerator(){

    }

}