package com.example.app.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import javax.persistence.*

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    var username = ""

    @Column(unique = true)
    var email = ""

    var password = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }

    val firstName: String = ""

    val lastName: String = ""

    @JsonManagedReference
    @OneToMany(cascade = [(CascadeType.ALL)], orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    var posts: List<Post>? = null
}