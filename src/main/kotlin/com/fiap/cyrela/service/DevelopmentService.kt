package com.fiap.cyrela.service

import com.fiap.cyrela.model.Development
import com.fiap.cyrela.request.DevelopmentRequest

interface DevelopmentService {
    fun createDevelopment(developmentRequest: DevelopmentRequest): Development?
}