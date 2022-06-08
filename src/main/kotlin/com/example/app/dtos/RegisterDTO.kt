package com.scalablescripts.auth.dtos

import javax.validation.constraints.Size

class RegisterDTO {
    @Size(min = 2, max = 25, message = "{username.size}")
    val username = ""
    val email = ""
    val password = ""
}