package com.example.app.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Null
import javax.validation.constraints.Size

@Entity
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    var userId: Long = 0

    @get: NotBlank(message = "{title.required}")
    @get: Size(min = 2, max = 50, message = "{title.size}")
    var title: String = ""

//    @JsonBackReference
//    @ManyToOne
//    val user: User
}