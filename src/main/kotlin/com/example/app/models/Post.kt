package com.example.app.models

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    var userId: Long = 0

    var title: String = ""

//    @JsonBackReference
//    @ManyToOne
//    val user: User
}