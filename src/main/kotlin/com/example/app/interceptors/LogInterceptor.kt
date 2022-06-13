package com.example.app.interceptors

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class LogInterceptor: HandlerInterceptor {

    val log = LoggerFactory.getLogger(LogInterceptor::class.java);

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any) : Boolean{
        log.info("LogInterceptor PreHandle log")
        return true
    }

    override fun postHandle(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any, model: ModelAndView?){
        log.info("LogInterceptor PostHandle log")
    }

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, dataObject: Any, e: Exception?) {
        log.info("LogInterceptor AfterCompletion log")
    }
}