package com.example.app


import com.example.app.models.Post
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post


@SpringBootTest(properties = arrayOf("spring.profiles.active=test")) // use the application-test.properties defined database
@AutoConfigureMockMvc
class PostTests(
	@Autowired val mockMvc: MockMvc,
	@Autowired val objectMapper: ObjectMapper
) {
	@Test
	fun `Assert that we can create an Post`() {

		val post = Post()
		val title = "A title"
		post.title = title

		mockMvc.post("/api/posts") {
			contentType = MediaType.APPLICATION_JSON
			content = objectMapper.writeValueAsString(post)
		}
			.andExpect {
				status { isOk() }
				content { contentType(MediaType.APPLICATION_JSON) }
				jsonPath("$.title") { value(title) }
			}
	}

}