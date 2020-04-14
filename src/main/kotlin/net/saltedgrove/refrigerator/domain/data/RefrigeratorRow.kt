package net.saltedgrove.refrigerator.domain.data

import net.saltedgrove.refrigerator.domain.Refrigerator
import javax.persistence.*

@Entity
@Table(name ="refrigerators")
class RefrigeratorRow (){
    @Id
    @Embedded
    var refrigeratorKey : RefrigeratorKey? = null
    constructor(refrigerator: Refrigerator) : this(){
        refrigeratorKey = RefrigeratorKey(name = refrigerator.name, ownerName = refrigerator.ownerName)
    }
}