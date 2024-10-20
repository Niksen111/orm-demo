package com.example.niksen111.repository

import com.example.niksen111.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository: JpaRepository<Order, Long> {
    fun findByUserId(userId: Long): List<Order>
}