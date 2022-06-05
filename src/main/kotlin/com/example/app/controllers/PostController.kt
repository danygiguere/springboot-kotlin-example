package com.example.app.controllers

import com.example.app.models.Post
import com.example.app.repositories.PostRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class PostController(private val postRepository: PostRepository) {

    @GetMapping("/posts")
    fun index(): List<Post> = postRepository.findAll()

    @GetMapping("/posts/{id}")
    fun show(@PathVariable(value = "id") postId: Long): ResponseEntity<Post> {
        return postRepository.findById(postId).map { post ->
            ResponseEntity.ok(post)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/posts")
    fun create(@Valid @RequestBody post: Post): ResponseEntity<Post>? {
        val hardcodedLoggedInUserId = 1
        post.userId = hardcodedLoggedInUserId.toLong()
        val newPost = postRepository.save(post)
        return newPost.id?.let {
            postRepository.findById(it).map { post ->
                ResponseEntity.ok(post)
            }.orElse(ResponseEntity.notFound().build())
        }
    }

    @PutMapping("/posts/{id}")
    fun update(@PathVariable(value = "id") postId: Long,
                          @Valid @RequestBody newPost: Post): ResponseEntity<Post> {
        return postRepository.findById(postId).map { post ->
            val updatedPost: Post = post.copy(title = newPost.title)
            ResponseEntity.ok().body(postRepository.save(updatedPost))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/posts/{id}")
    fun delete(@PathVariable(value = "id") postId: Long): ResponseEntity<Void> {
        return postRepository.findById(postId).map { post ->
            postRepository.delete(post)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}