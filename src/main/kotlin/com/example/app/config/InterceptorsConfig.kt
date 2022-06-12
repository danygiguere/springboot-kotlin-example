package com.example.app.config

import com.example.app.interceptors.LogInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@EnableWebMvc
class InterceptorsConfig : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(LogInterceptor())
//        registry.addInterceptor(LogInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**")

        // multiple urls (same is possible for `exludePathPatterns`)
//        registry.addInterceptor(LogInterceptor()).addPathPatterns("/secure/*", "/admin/**", "/profile/**")
    }
}