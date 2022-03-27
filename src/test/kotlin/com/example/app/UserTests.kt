package com.example.app


import com.example.app.models.User
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post


@SpringBootTest(properties = arrayOf("spring.profiles.active=test")) // use the application-test.properties defined database
@AutoConfigureMockMvc
class UserTests(
	@Autowired val mockMvc: MockMvc,
	@Autowired val objectMapper: ObjectMapper
) {
	@Test
	fun `Assert that we can create an User`() {
		val username = "johndoe"
		val johndoe = User(null, username, "johndoe1@test.com", "secret", "john", "doe1",null)

		mockMvc.post("/api/users") {
			contentType = MediaType.APPLICATION_JSON
			content = objectMapper.writeValueAsString(johndoe)
		}
			.andExpect {
				status { isCreated() }
				content { contentType(MediaType.APPLICATION_JSON) }
				jsonPath("$.username") { value(username) }
			}
	}

}