package com.garsemar.webproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class WebProjectApplication{
    @GetMapping
    fun hello(): List<String> {
        return listOf("Hello", "World")
    }
}

fun main(args: Array<String>) {
    runApplication<WebProjectApplication>(*args)
}