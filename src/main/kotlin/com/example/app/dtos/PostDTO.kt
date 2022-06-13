package com.example.app.dtos

import javax.validation.constraints.Size

class PostDTO {
    @Size(min = 6, max = 25, message = "{title.size}")
    val title = ""
}