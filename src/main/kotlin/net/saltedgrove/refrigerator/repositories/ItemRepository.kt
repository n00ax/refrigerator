package net.saltedgrove.refrigerator.repositories

import net.saltedgrove.refrigerator.domain.BuiltInCategory
import net.saltedgrove.refrigerator.domain.data.ItemKey
import net.saltedgrove.refrigerator.domain.data.ItemRow
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ItemRepository : JpaRepository<ItemRow, ItemKey>{
    @Query(value = "SELECT * FROM items WHERE items.owner_name = ? AND items.refrigerator_name = ?", nativeQuery = true)
    fun findByRefrigerator(refrigeratorName: String?, ownerName : String?) : List<ItemRow>
    // Get's category rows, not total items
    @Query(value = "SELECT SUM(item_count) FROM items WHERE items.refrigerator_name = ? AND items.owner_name = ? " +
            "AND items.built_in_category = ?", nativeQuery = true)
    fun getBuiltInCategoryCount(refrigeratorName: String?, ownerName : String?, builtInCategoryString : String?) : Int
}