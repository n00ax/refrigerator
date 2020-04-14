package net.saltedgrove.refrigerator.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import net.saltedgrove.refrigerator.domain.data.ItemRow
import net.saltedgrove.refrigerator.domain.data.RefrigeratorKey
import java.time.ZonedDateTime

// Item used for aggregate, also annoying that Kotlin doesn't allow data class inheritance
data class AggregateItem(
        val name : String,
        val description : String,
        val expiry : ZonedDateTime,
        var count : Int,
        val builtInCategory : BuiltInCategory,
        val category : String?){
    fun toItem(refrigeratorKey : RefrigeratorKey) : Item{
        return Item(name = name, description = description, expiry = expiry, count = count,
                builtInCategory = builtInCategory, category = category, refrigeratorKey = refrigeratorKey)
    }
    constructor(itemRow : ItemRow) : this(name = itemRow.itemKey!!.name!!, description = itemRow.itemKey!!.description!!,
            expiry = itemRow.itemKey!!.expiry!!, count = itemRow.count!!, builtInCategory = itemRow.itemKey!!.builtInCategory!!,
            category = itemRow.itemKey!!.category)
}