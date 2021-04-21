package com.fiap.cyrela.service.impl

import com.fiap.cyrela.model.User
import com.fiap.cyrela.repository.UserRepository
import com.fiap.cyrela.request.UserRequest
import com.fiap.cyrela.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        private val userRepository: UserRepository
) : UserService {
    override fun createUser(userRequest: UserRequest): User =
        userRepository.save(User.toModel(userRequest))
}