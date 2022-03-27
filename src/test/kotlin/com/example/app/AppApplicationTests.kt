package com.example.app

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class AppApplicationTests(
	@Autowired val mockMvc: MockMvc,
	@Autowired val objectMapper: ObjectMapper
) {
	@Test
	fun `Assert homepage returns a 200`() {
		mockMvc.get("/")
			.andExpect {
				status { isOk() }
			}
	}


}