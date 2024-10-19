package com.example.niksen111.repository

import com.example.niksen111.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, Long> {
}