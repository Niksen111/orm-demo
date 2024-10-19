package com.example.niksen111.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "products")
class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false, precision = 10, scale = 2)
        val price: BigDecimal
) {
    constructor() : this(0, "", BigDecimal.ZERO)
}
