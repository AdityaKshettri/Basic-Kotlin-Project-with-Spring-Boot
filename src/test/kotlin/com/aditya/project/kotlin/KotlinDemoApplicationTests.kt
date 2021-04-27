package com.aditya.project.kotlin

import com.aditya.project.kotlin.dto.HelloDto
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest(
		classes = [KotlinDemoApplication::class],
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class KotlinDemoApplicationTests {

	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun should_return_hello_when_hello_called() {
		val result = testRestTemplate.getForEntity("/hello", String::class.java)
		assertNotNull(result)
		assertEquals(result?.statusCode, HttpStatus.OK)
		assertEquals(result?.body, "hello-world")
	}

	@Test
	fun should_return_hello_when_hello_service_called() {
		val result = testRestTemplate.getForEntity("/hello-service", String::class.java)
		assertNotNull(result)
		assertEquals(result?.statusCode, HttpStatus.OK)
		assertEquals(result?.body, "hello-world-service")
	}

	@Test
	fun should_return_hello_when_hello_dto_called() {
		val result = testRestTemplate.getForEntity("/hello-dto", String::class.java)
		assertNotNull(result)
		assertEquals(result?.statusCode, HttpStatus.OK)
		assertEquals(result?.body, "{\"greeting\":\"hello-world-dto\"}")
	}
}
