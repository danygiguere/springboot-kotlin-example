package com.example.app.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {

        // Disable CSRF
        http.csrf().disable()

        http.authorizeRequests()
            .antMatchers("/", "/api/register", "/api/login").permitAll()
            .anyRequest()
            .authenticated()
    }
}