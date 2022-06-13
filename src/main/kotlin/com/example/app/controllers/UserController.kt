package com.example.app.controllers

import com.example.app.models.User
import com.example.app.repositories.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class UserController(private val userRepository: UserRepository) {

    @GetMapping("/users")
    fun index(): List<User> = userRepository.findAll()

    @GetMapping("/users/{id}")
    fun show(@PathVariable(value = "id") userId: Long): ResponseEntity<User> {
        return userRepository.findById(userId).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/users/{id}")
    fun update(@PathVariable(value = "id") userId: Long,
                          @Valid @RequestBody newUser: User): ResponseEntity<User> {
        return userRepository.findById(userId).map { user ->
            user.username = newUser.username
            ResponseEntity.ok().body(userRepository.save(user))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/users/{id}")
    fun delete(@PathVariable(value = "id") userId: Long): ResponseEntity<Void> {
        return userRepository.findById(userId).map { user ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}