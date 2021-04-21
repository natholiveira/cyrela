package com.fiap.cyrela.service

import com.fiap.cyrela.model.User
import com.fiap.cyrela.request.UserRequest

interface UserService {
    fun createUser(userRequest: UserRequest): User
}