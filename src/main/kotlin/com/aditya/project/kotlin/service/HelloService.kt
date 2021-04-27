package com.aditya.project.kotlin.service

import org.springframework.stereotype.Service

@Service
class HelloService {

    fun getHello(): String {
        return "hello-world-service"
    }
}