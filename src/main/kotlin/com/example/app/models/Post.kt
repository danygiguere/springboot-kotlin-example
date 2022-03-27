package com.example.app.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
data class Post (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @get: NotBlank(message = "{title.required}")
    @get: Size(min=2, max=50, message = "{title.size}")
    val title: String = "",

    @JsonBackReference
    @ManyToOne
    val user: User
)