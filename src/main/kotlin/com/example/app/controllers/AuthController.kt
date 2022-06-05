package com.example.app.controllers

import com.example.app.models.User
import com.example.app.repositories.UserRepository
import com.scalablescripts.auth.dtos.RegisterDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AuthController(private val userRepository: UserRepository) {

    @PostMapping("/register")
    fun register(@RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User()
        user.username = body.username
        user.email = body.email
        user.password = body.password

        return ResponseEntity.ok(this.userRepository.save(user))
    }

}