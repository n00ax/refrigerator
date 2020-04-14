package net.saltedgrove.refrigerator.domain

import net.saltedgrove.refrigerator.domain.data.RefrigeratorKey
import net.saltedgrove.refrigerator.domain.data.RefrigeratorRow

data class Refrigerator(
        // Unique = Name, ownerName
        val name : String,
        val ownerName : String,
        val items : List<AggregateItem>){
    constructor(refrigerator: RefrigeratorRow?, items : List<AggregateItem>) : this(
            name = refrigerator!!.refrigeratorKey!!.name!!, ownerName = refrigerator!!.refrigeratorKey!!.ownerName!!,
            items = items)
    fun toKey() : RefrigeratorKey{
        return RefrigeratorKey(name, ownerName)
    }
}