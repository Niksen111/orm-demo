package com.example.niksen111.controller

import com.example.niksen111.entity.User
import com.example.niksen111.repository.OrderProductRepository
import com.example.niksen111.repository.OrderRepository
import com.example.niksen111.repository.ProductRepository
import com.example.niksen111.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MainController(
    private val userRepository: UserRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository,
    private val orderProductRepository: OrderProductRepository
) {
    @GetMapping("/users")
   fun getAllUsers(): ResponseEntity<List<User>> {
       return ResponseEntity(userRepository.findAll(), HttpStatus.OK)
   }
}