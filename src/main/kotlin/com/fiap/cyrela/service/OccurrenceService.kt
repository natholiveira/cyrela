package com.fiap.cyrela.service

import com.fiap.cyrela.model.Occurrence
import com.fiap.cyrela.request.OccurrenceRequest

interface OccurrenceService {

    fun createOccurrence(occurrenceRequest: OccurrenceRequest) : Occurrence?
    fun getAllOccurrence(unityId: Long?) : List<Occurrence>
    fun getOccurrenceById(occurrenceId: Long) : Occurrence?
    fun getOccurrenceByTicketNumber(ticketNumber: String) : Occurrence?

}