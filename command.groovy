//you can run this script by running the following command from the terminal: `spring run command.groovy`

package com.example.app

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class command {

    @RequestMapping("/")
    String homepage() {
        return "This is the homepage response from command.groovy"
    }

}