package com.example.niksen111.service.impl

import com.example.niksen111.entity.Order
import com.example.niksen111.entity.OrderProduct
import com.example.niksen111.repository.OrderProductRepository
import com.example.niksen111.repository.OrderRepository
import com.example.niksen111.repository.ProductRepository
import com.example.niksen111.service.OrderService
import com.example.niksen111.vo.OrderWithUser
import com.example.niksen111.vo.ProductWithQuantity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val orderProductRepository: OrderProductRepository,
    private val productRepository: ProductRepository
) : OrderService {
    @Transactional
    override fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }

    override fun getOrdersByUserId(userId: Long): List<Order> {
        return orderRepository.findByUserId(userId)
    }

    @Transactional
    override fun addProductToOrder(orderId: Long, productId: Long, quantity: Int) {
        val order = orderRepository.findById(orderId).orElseThrow {
            throw IllegalArgumentException("Order with id $orderId not found")
        }
        val product = productRepository.findById(productId).orElseThrow {
            throw IllegalArgumentException("Product with id $productId not found")
        }

        val orderProduct = OrderProduct(
            order = order,
            product = product,
            quantity = quantity
        )
        orderProductRepository.save(orderProduct)
    }

    override fun getProductsByOrderId(orderId: Long): List<ProductWithQuantity> {
        return orderProductRepository.findByOrderId(orderId).map {
            ProductWithQuantity(
                it.product.name,
                it.product.price,
                it.quantity)
        }
    }

    override fun getOrdersAndUsersNPlusOneProblem(): List<OrderWithUser> {
        val orders = orderRepository.findAll()
        return orders.map { order ->
            OrderWithUser(
                order.id,
                order.user.name,
                order.user.email
            )
        }
    }
}