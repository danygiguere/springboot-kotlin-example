package com.example.app.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column
    var username = ""

    @Column(unique = true)
    var email = ""

    @Column
    var password = ""
        @JsonIgnore
        get() = field
//        set(value) {
//            val passwordEncoder = BCryptPasswordEncoder()
//            field = passwordEncoder.encode(value)
//        }

//    fun comparePassword(password: String): Boolean {
//        return BCryptPasswordEncoder().matches(password, this.password)
//    }

    @Column
    val firstName: String = ""

    @Column
    val lastName: String = ""

    @JsonManagedReference
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    var posts: List<Post>? = null
}


//@Entity
//data class User (
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long? = null,
//
//    @get: NotBlank
//    val username: String = "",
//
//    @get: NotBlank
//    val email: String = "",
//
//    @get: NotBlank
//    @JsonIgnore
//    val password: String = "",
//
//    val firstName: String = "",
//
//    val lastName: String = "",
//
//    @JsonManagedReference
//    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId", referencedColumnName = "id")
//    var posts: List<Post>?
//)
