package com.example.app.controllers

import com.example.app.dtos.LoginDTO
import com.example.app.dtos.RegisterDTO
import com.example.app.models.User
import com.example.app.repositories.UserRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class AuthController(private val userRepository: UserRepository) {

    @Autowired
    private val messageSource: ResourceBundleMessageSource? = null
    var logger: Logger = LoggerFactory.getLogger(DemoController::class.java)

    @PostMapping("/register")
    fun register(@Valid @RequestBody body: RegisterDTO): ResponseEntity<User> {
        val user = User()
        user.username = body.username
        user.email = body.email
        user.password = body.password

        return ResponseEntity.ok(this.userRepository.save(user))
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody body: LoginDTO, response: HttpServletResponse): String {
        val user = this.userRepository.findByEmail(body.email)
            ?: return messageSource!!.getMessage("user_not_found", null, LocaleContextHolder.getLocale())

        if (!user.comparePassword(body.password)) {
            return messageSource!!.getMessage("invalid_password", null, LocaleContextHolder.getLocale())
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return messageSource!!.getMessage("welcome", null, LocaleContextHolder.getLocale())
    }

    @GetMapping("/user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
        try {
            logger.info("AuthController @/user");
            if (jwt == null) {
                return ResponseEntity.status(401).body(messageSource!!.getMessage("unauthenticated", null, LocaleContextHolder.getLocale()))
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body

            return ResponseEntity.ok(this.userRepository.findById(body.issuer.toInt().toLong()))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(messageSource!!.getMessage("unauthenticated", null, LocaleContextHolder.getLocale()))
        }
    }

    @PostMapping("/logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok(messageSource!!.getMessage("logged_out", null, LocaleContextHolder.getLocale()))
    }

}