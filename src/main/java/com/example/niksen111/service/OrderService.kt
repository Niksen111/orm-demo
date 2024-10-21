package com.example.niksen111.service

import com.example.niksen111.entity.Order
import com.example.niksen111.vo.OrderWithUser
import com.example.niksen111.vo.ProductWithQuantity

interface OrderService {
    fun createOrder(order: Order): Order

    fun getOrdersByUserId(userId: Long): List<Order>

    fun addProductToOrder(orderId: Long, productId: Long, quantity: Int)

    fun getProductsByOrderId(orderId: Long): List<ProductWithQuantity>

    fun getOrdersAndUsersNPlusOneProblem(): List<OrderWithUser>
}