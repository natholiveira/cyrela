package com.fiap.cyrela.repository

import com.fiap.cyrela.model.Unity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UnityRepository : JpaRepository<Unity, Long>