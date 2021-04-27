package com.aditya.project.kotlin.controller

import com.aditya.project.kotlin.dto.HelloDto
import com.aditya.project.kotlin.service.HelloService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(val helloService: HelloService) {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello-world"
    }

    @GetMapping("/hello-service")
    fun helloService(): String {
        return helloService.getHello()
    }

    @GetMapping("/hello-dto")
    fun helloDto(): HelloDto {
        return HelloDto("hello-world-dto")
    }
}