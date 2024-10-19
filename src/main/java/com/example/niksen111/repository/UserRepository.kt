package com.example.niksen111.repository

import com.example.niksen111.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}