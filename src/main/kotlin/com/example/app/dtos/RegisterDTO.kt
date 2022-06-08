package com.scalablescripts.auth.dtos

import javax.validation.constraints.Email
import javax.validation.constraints.Size

class RegisterDTO {
    @Size(min = 6, max = 25, message = "{username.size}")
    val username = ""

    @Email(message = "{email}")
    // todo add unique email validation here
    val email = ""

    @Size(min = 6, max = 25, message = "{password.size}")
    // todo validated that both passwords match
    val password = ""
}