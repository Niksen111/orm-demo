package com.example.niksen111.vo

import java.math.BigDecimal

data class ProductWithQuantity(
    val name: String,
    val price: BigDecimal,
    val quantity: Int
)
