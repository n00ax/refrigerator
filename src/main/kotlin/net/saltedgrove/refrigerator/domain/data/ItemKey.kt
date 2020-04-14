package net.saltedgrove.refrigerator.domain.data

import jdk.jfr.Description
import net.saltedgrove.refrigerator.domain.BuiltInCategory
import net.saltedgrove.refrigerator.domain.Item
import java.io.Serializable
import java.time.ZonedDateTime
import javax.persistence.*

@Embeddable
class ItemKey() : Serializable{
    @Column(name = "item_name", columnDefinition = "text")
    var name: String? = null
    @Column(name = "description", columnDefinition = "text")
    var description: String? = null
    @Column(name = "expiry", columnDefinition = "timestamp")
    var expiry: ZonedDateTime? = null
    @Column(name = "built_in_category", columnDefinition = "text")
    @Enumerated(EnumType.STRING)
    var builtInCategory: BuiltInCategory? = null
    @Column(name = "category", columnDefinition = "text")
    var category: String? = null
    @Embedded
    var refrigeratorKey: RefrigeratorKey? = null
    constructor(name : String, description: String, expiry : ZonedDateTime, builtInCategory: BuiltInCategory,
                category : String?, refrigeratorKey: RefrigeratorKey) : this() {
        this.name = name
        this.description = description
        this.expiry = expiry
        this.builtInCategory = builtInCategory
        this.category = category
        this.refrigeratorKey = refrigeratorKey
    }
    constructor(item : Item) : this(item.name, item.description, item.expiry, item.builtInCategory, item.category,
            item.refrigeratorKey)
}