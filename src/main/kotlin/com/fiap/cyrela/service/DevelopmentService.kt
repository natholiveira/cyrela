package com.fiap.cyrela.service

import com.fiap.cyrela.model.Development
import com.fiap.cyrela.model.User
import com.fiap.cyrela.request.DevelopmentRequest
import com.fiap.cyrela.request.UserRequest

interface DevelopmentService {
    fun createDevelopment(developmentRequest: DevelopmentRequest): Development?
}