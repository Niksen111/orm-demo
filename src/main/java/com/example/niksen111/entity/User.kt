package com.example.niksen111.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(nullable = false)
        val name: String,

        @Column(nullable = false, unique = true)
        val email: String,

        @Column(name= "created_at", nullable = false)
        val createdAt: LocalDateTime = LocalDateTime.now()
) {
    constructor() : this(name = "", email = "")
}
