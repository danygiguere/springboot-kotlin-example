package com.scalablescripts.auth.dtos

import javax.validation.constraints.Size

class RegisterDTO {
    @get: Size(max = 4, message = "{username.size}")
    val username = ""
    val email = ""
    val password = ""
}