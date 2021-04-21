package com.fiap.cyrela.repository

import com.fiap.cyrela.model.Development
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DevelopmentRepository : JpaRepository<Development, Long>