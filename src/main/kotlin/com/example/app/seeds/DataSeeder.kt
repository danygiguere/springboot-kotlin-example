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
            val user1 = User(null, "johndoe1", "johndoe1@test.com", "secret", "john", "doe1",null)
            val user2 = User(null, "johndoe2", "johndoe2@test.com", "secret", "john", "doe2",null)
            val user3 = User(null, "johndoe3", "johndoe3@test.com", "secret", "john", "doe3",null)
            val user4 = User(null, "johndoe4", "johndoe4@test.com", "secret", "john", "doe4",null)
            val user5 = User(null, "johndoe5", "johndoe5@test.com", "secret", "john", "doe5",null)
            userRepository.save(user1)
            userRepository.save(user2)
            userRepository.save(user3)
            userRepository.save(user4)
            userRepository.save(user5)

            val post1 = Post(null, "A title", user1)
            val post2 = Post(null, "Another title", user1)
            val post3 = Post(null, "Another title", user1)
            val post4 = Post(null, "Another title", user2)
            val post5 = Post(null, "Another title", user2)
            postRepository.save(post1)
            postRepository.save(post2)
            postRepository.save(post3)
            postRepository.save(post4)
            postRepository.save(post5)
        } else {
            //
        }
    }

}