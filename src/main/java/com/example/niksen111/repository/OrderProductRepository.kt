package com.example.niksen111.repository

import com.example.niksen111.entity.OrderProduct
import org.springframework.data.jpa.repository.JpaRepository

interface OrderProductRepository : JpaRepository<OrderProduct, Long> {
    fun findByOrderId(orderId: Long): List<OrderProduct>
}