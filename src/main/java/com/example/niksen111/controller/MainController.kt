package com.example.niksen111.controller

import com.example.niksen111.entity.Order
import com.example.niksen111.entity.User
import com.example.niksen111.repository.UserRepository
import com.example.niksen111.service.OrderService
import com.example.niksen111.vo.OrderProductRequest
import com.example.niksen111.vo.OrderWithUser
import com.example.niksen111.vo.ProductWithQuantity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainController(
    private val userRepository: UserRepository,
    private val orderService: OrderService
) {
    @GetMapping("/users")
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity(userRepository.findAll(), HttpStatus.OK)
    }

    @PostMapping("/addUser")
    fun addUser(user: User): ResponseEntity<User> {
        return ResponseEntity(userRepository.save(user), HttpStatus.OK)
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userRepository.findById(id) ?: null
        return if (user != null) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/users/{userId}/createOrder")
    fun createOrder(@PathVariable userId: Long): ResponseEntity<String> {
        val user = userRepository.findById(userId) ?: return ResponseEntity.notFound().build()
        val order = Order(user.get())
        orderService.createOrder(order)
        return ResponseEntity.ok("Order created successfully for user ID $userId")
    }

    @GetMapping("/users/{id}/orders")
    fun getOrdersByUserId(@PathVariable id: Long): ResponseEntity<List<Order>> {
        val orders = orderService.getOrdersByUserId(id)
        return if (orders.isNotEmpty()) {
            ResponseEntity.ok(orders)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/orders/{orderId}/addProductToOrder")
    fun addProductToOrder(
        @PathVariable orderId: Long,
        @RequestBody productRequest: OrderProductRequest
    ): ResponseEntity<String> {
        orderService.addProductToOrder(orderId, productRequest.productId, productRequest.quantity)
        return ResponseEntity.ok("Product added to order successfully")
    }

    @GetMapping("/orders/{orderId}/getDetailed")
    fun getOrderDetailed(@PathVariable orderId: Long): ResponseEntity<List<ProductWithQuantity>> {
        return ResponseEntity.ok(orderService.getProductsByOrderId(orderId))
    }

    @GetMapping("/ordersWithUsersNP1")
    fun getOrdersWithUsersNP1(): ResponseEntity<List<OrderWithUser>> {
        return ResponseEntity.ok(orderService.getOrdersAndUsersNPlusOneProblem())
    }
}