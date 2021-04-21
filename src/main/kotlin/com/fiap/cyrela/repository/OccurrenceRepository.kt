package com.fiap.cyrela.repository

import com.fiap.cyrela.model.Occurrence
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface OccurrenceRepository : JpaRepository<Occurrence, Long> {
    fun findAllByUnityId(unityId: Long): List<Occurrence>?
    fun findOneByTicketNumber(ticketNumber: String): Occurrence?
    fun existsByTicketNumber(ticketNumber: String): Boolean
}