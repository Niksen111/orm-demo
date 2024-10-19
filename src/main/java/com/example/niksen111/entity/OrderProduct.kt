package com.example.niksen111.entity

import jakarta.persistence.*

@Entity
@Table(name = "order_products")
class OrderProduct(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id", nullable = false)
        val order: Order,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", nullable = false)
        val product: Product,

        @Column(nullable = false)
        val quantity: Int
) {
    constructor() : this(0, Order(), Product(), 0)
}
