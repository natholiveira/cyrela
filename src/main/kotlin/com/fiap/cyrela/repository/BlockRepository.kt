package com.fiap.cyrela.repository

import com.fiap.cyrela.model.Block
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlockRepository : JpaRepository<Block, Long>