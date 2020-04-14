package net.saltedgrove.refrigerator.domain.data

import net.saltedgrove.refrigerator.domain.BuiltInCategory
import net.saltedgrove.refrigerator.domain.Item
import java.time.ZonedDateTime
import javax.persistence.*

@Entity
@Table(name = "items")
class ItemRow(){
    @Id
    @Embedded
    var itemKey : ItemKey? = null
    @Column(name = "item_count", columnDefinition = "int")
    var count : Int? = null
    constructor(item : Item) : this() {
        count = item.count
        this.itemKey =  ItemKey(name = item.name, description = item.description, expiry = item.expiry,
                builtInCategory = item.builtInCategory, category = item.category, refrigeratorKey = item.refrigeratorKey)
    }
}