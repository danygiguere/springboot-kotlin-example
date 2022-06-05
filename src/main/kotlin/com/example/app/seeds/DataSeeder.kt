package com.example.app.seeds

import com.example.app.models.Post
import com.example.app.models.User
import com.example.app.repositories.PostRepository
import com.example.app.repositories.UserRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component


@Component
class DataSeeder(private val userRepository: UserRepository, private val postRepository: PostRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        val users = userRepository.findAll()
        if (users.size <= 0) {
            val user1 = User()
            user1.username = "johndoe1"
            user1.email = "johndoe1@test.com"
            user1.password = "secret"
            userRepository.save(user1)

            val user2 = User()
            user2.username = "johndoe2"
            user2.email = "johndoe2@test.com"
            user2.password = "secret"
            userRepository.save(user2)

            val post1 = Post()
            post1.userId = 1
            post1.title = "A title"
            postRepository.save(post1)

            val post2 = Post()
            post2.userId = 2
            post2.title = "A title"
            postRepository.save(post2)

        } else {
            //
        }
    }

}