package com.example.app.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {

        // Enable CORS and disable CSRF
        http.cors().and().csrf().disable()

        http.authorizeRequests()
            .antMatchers("/", "/api/register", "/api/login").permitAll()
            .anyRequest()
            .authenticated()
    }
}