package com.fiap.cyrela.service.impl

import com.fiap.cyrela.request.OccurrenceRequest
import com.fiap.cyrela.exception.InvalidUnityException
import com.fiap.cyrela.exception.TicketNumberAlreadyExistsException
import com.fiap.cyrela.model.Occurrence
import com.fiap.cyrela.repository.OccurrenceRepository
import com.fiap.cyrela.repository.UnityRepository
import com.fiap.cyrela.service.OccurrenceService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OccurrenceServiceImpl(
        private val occurrenceRepository: OccurrenceRepository,
        private val unityRepository: UnityRepository
) : OccurrenceService {
    override fun createOccurrence(occurrenceRequest: OccurrenceRequest) =
        if (!existsTicketNumber(occurrenceRequest.ticketNumber!!)) {
            unityRepository.findByIdOrNull(occurrenceRequest.unityId)?.let {
                occurrenceRepository.save(Occurrence.toModel(occurrenceRequest, it))
            } ?: throw InvalidUnityException("Unity not found")
        } else throw TicketNumberAlreadyExistsException("Ticket number already exists")

    override fun getAllOccurrence(unityId: Long?): List<Occurrence> =
        unityId?.let {
            occurrenceRepository.findAllByUnityId(it)
        } ?: occurrenceRepository.findAll()


    override fun getOccurrenceById(occurrenceId: Long): Occurrence? =
        occurrenceRepository.findByIdOrNull(occurrenceId)

    override fun getOccurrenceByTicketNumber(ticketNumber: String): Occurrence? =
            occurrenceRepository.findOneByTicketNumber(ticketNumber)

    private fun existsTicketNumber(ticketNumber: String) =
        occurrenceRepository.existsByTicketNumber(ticketNumber)
}