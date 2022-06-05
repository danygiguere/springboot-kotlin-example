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

    val firstName: String = "",

    val lastName: String = "",

    @JsonManagedReference
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    var posts: List<Post>?
)