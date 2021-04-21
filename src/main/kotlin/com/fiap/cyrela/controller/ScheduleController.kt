package com.fiap.cyrela.controller

import com.fiap.cyrela.exception.BadRequestExceptioin
import com.fiap.cyrela.exception.NotFoundExeption
import com.fiap.cyrela.extension.toDate
import com.fiap.cyrela.request.ScheduleRequest
import com.fiap.cyrela.model.Schedule
import com.fiap.cyrela.service.ScheduleService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
class ScheduleController(
        val scheduleService: ScheduleService
) {
    @GetMapping("/api/schedule")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "List all schedules and can filter by unit and typeActivity")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 200, message = "Return list of Schedule")
    ))
    fun getAllSchedule(@RequestParam unityId: Long?,
                       @RequestParam typeActivity: String?) =
       scheduleService.getAllSchedule(typeActivity, unityId)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/schedule")
    @ApiOperation(value = "Create new Schedule")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 201, message = "Created new Schedule"),
            ApiResponse(code = 400, message = "Bad Request"),
            ApiResponse(code = 404, message = "Unity Not Found")
    ))
    fun createSchedule(@RequestBody  @Valid scheduleRequest: ScheduleRequest, bindingResult: BindingResult) =
            if (bindingResult.hasErrors()) {
                throw BadRequestExceptioin()
            } else scheduleService.createSchedule(scheduleRequest)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/schedule/{id}")
    @ApiOperation(value = "Obtain Schedule by Id")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 200, message = "Return Schedule"),
            ApiResponse(code = 404, message = "Occurrence Not Found")
    ))
    fun findById(@PathVariable id: Long) =
            scheduleService.getScheduleById(id) ?: throw NotFoundExeption("Schedule Not Found")
}