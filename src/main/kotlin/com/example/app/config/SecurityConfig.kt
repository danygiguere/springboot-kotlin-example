package com.example.app.config

import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .mvcMatchers(HttpMethod.GET, "/**").permitAll() // GET requests don't need auth
            .anyRequest()
            .authenticated()
    }
}