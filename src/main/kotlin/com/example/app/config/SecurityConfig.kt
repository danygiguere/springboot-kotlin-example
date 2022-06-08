package com.example.app.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        // Disable CSRF
//        http.csrf().disable()
        http.cors().and().csrf().disable()

        http.authorizeRequests()
            .antMatchers(
                "/",
                "/api/register",
                "/api/login",
            "/api/logout")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
}