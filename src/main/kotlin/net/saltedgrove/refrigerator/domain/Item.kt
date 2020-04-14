package net.saltedgrove.refrigerator.domain

import net.saltedgrove.refrigerator.domain.data.ItemRow
import net.saltedgrove.refrigerator.domain.data.RefrigeratorKey
import java.time.ZonedDateTime

data class Item(
        val name : String,
        val description : String,
        val expiry : ZonedDateTime,
        var count : Int,
        val builtInCategory : BuiltInCategory,
        val category : String?,
        val refrigeratorKey: RefrigeratorKey)