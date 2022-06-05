package com.example.app.controllers

import com.example.app.models.User
import com.example.app.repositories.UserRepository
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.i18n.LocaleContextHolder.getLocale
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class DemoController(private val userRepository: UserRepository) {

    @Autowired
    private val messageSource: ResourceBundleMessageSource? = null
    var logger: Logger = LoggerFactory.getLogger(DemoController::class.java)

    @GetMapping("/")
    fun getHomePage(): String {
        logger.info("An INFO Message");
        return messageSource!!.getMessage("welcome", null, getLocale())
    }

    @GetMapping("/loggers")
    fun loggers(): String {
        logger.trace("This is a TRACE message.");
        logger.debug("This is a DEBUG message.");
        logger.info("This is an INFO message.");
        logger.warn("This is a WARN message.");
        logger.error("You guessed it, an ERROR message.");
        return "Welcome to Spring Logging! Check the console to see the log messages.";
    }

    @GetMapping("/test")
    fun test(): User? {
        return userRepository.findByEmail("johndoe1@test.com")
    }
}