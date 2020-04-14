package net.saltedgrove.refrigerator.domain.data

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class RefrigeratorKey() : Serializable{
    @Column(name = "refrigerator_name", columnDefinition = "text")
    var name: String? = null
    @Column(name = "owner_name", columnDefinition = "text")
    var ownerName: String? = null
    constructor(name : String, ownerName : String) : this() {
        this.name = name
        this.ownerName = ownerName
    }
}