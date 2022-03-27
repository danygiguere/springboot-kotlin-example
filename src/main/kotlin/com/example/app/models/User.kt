package com.example.app.models

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class User (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @get: NotBlank
    val username: String = "",

    @get: NotBlank
    val email: String = "",

    @get: NotBlank
    val password: String = "",

    val first_name: String = "",

    val last_name: String = "",


    @JsonManagedReference
    @OneToMany()
    var posts: List<Post>?
)