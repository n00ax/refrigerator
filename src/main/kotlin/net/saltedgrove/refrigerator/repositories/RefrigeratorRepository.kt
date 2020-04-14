package net.saltedgrove.refrigerator.repositories

import net.saltedgrove.refrigerator.domain.data.RefrigeratorKey
import net.saltedgrove.refrigerator.domain.data.RefrigeratorRow
import org.springframework.data.jpa.repository.JpaRepository

interface RefrigeratorRepository : JpaRepository<RefrigeratorRow, RefrigeratorKey>{

}