package com.example.niksen111

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class OrmDemoApplication

fun main(args: Array<String>) {
    runApplication<OrmDemoApplication>(*args)
}