package com.fiap.cyrela.service

import com.fiap.cyrela.request.ScheduleRequest
import com.fiap.cyrela.model.Schedule
import java.util.*

interface ScheduleService {
    fun createSchedule(scheduleRequest: ScheduleRequest): Schedule?
    fun getAllSchedule(typeActivity: String?, unityId: Long?): List<Schedule>
    fun getScheduleById(scheduleId: Long): Schedule?
}