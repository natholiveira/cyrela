package com.fiap.cyrela.service.impl

import com.fiap.cyrela.exception.InvalidUnityException
import com.fiap.cyrela.request.ScheduleRequest
import com.fiap.cyrela.model.Schedule
import com.fiap.cyrela.repository.ScheduleRepository
import com.fiap.cyrela.repository.UnityRepository
import com.fiap.cyrela.service.ScheduleService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ScheduleServiceImpl(
        private val scheduleRepository: ScheduleRepository,
        private val unityRepository: UnityRepository
) : ScheduleService {
    override fun createSchedule(scheduleRequest: ScheduleRequest): Schedule? =
        unityRepository.findByIdOrNull(scheduleRequest.unityId)?.let {
            scheduleRepository.save(Schedule.toModel(scheduleRequest, it))
        } ?: throw InvalidUnityException("Unity not found")

    override fun getAllSchedule(
            typeActivity: String?,
            unityId: Long?): List<Schedule> =
        scheduleRepository.findAllWithFilter(typeActivity, unityId)

    override fun getScheduleById(scheduleId: Long): Schedule? =
        scheduleRepository.findByIdOrNull(scheduleId)
}