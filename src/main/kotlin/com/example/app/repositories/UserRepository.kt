package com.example.app.repositories

import com.example.app.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {

    fun findById(id: Long?): User?

    fun findByUsername(username: String?): User?

    fun findByEmail(email: String?): User?

    fun findByLastName(lastName: String?): User?

//    enum class Credentials {
//        username, password
//    }

//    @Query("select u.username, u.password from User u where u.email = ?1")
//    fun getCredentialsByEmail(email: String?): Credentials?
}

