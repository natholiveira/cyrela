package com.fiap.cyrela.request

import java.util.*

data class UserRequest (
        val name: String? = null,
        val birthday: Date? = null,
        val login: String? = null,
        val password: String? = null,
)