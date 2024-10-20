package com.example.niksen111.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        val user: User,

        @Column(name = "order_date", nullable = false)
        val orderDate: LocalDateTime = LocalDateTime.now()
) {
        constructor() : this(user = User())
        constructor(user: User) : this(user = user, orderDate = LocalDateTime.now())
}