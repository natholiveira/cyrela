package com.fiap.cyrela.controller

import com.fiap.cyrela.exception.BadRequestExceptioin
import com.fiap.cyrela.request.OccurrenceRequest
import com.fiap.cyrela.exception.NotFoundExeption
import com.fiap.cyrela.model.Occurrence
import com.fiap.cyrela.service.OccurrenceService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Api(value = "Occurrence operations")
class OccurrenceController(
    val occurrenceService: OccurrenceService
) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/occurrence")
    @ApiOperation(value = "List all occurrences and can filter by unit")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 200, message = "Return list of occurence")
    ))
    fun getAllOccurrence(@RequestParam unityId: Long?): List<Occurrence> =
        occurrenceService.getAllOccurrence(unityId)

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/occurrence")
    @ApiOperation(value = "Create new Occurrence")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 201, message = "Created new Occurence"),
            ApiResponse(code = 400, message = "Bad Request"),
            ApiResponse(code = 406, message = "Ticket Number Arready Exists"),
            ApiResponse(code = 404, message = "Unity Not Found")
    ))
    fun createOccurrence(@RequestBody @Valid occurrenceRequest: OccurrenceRequest
                         ,bindingResult: BindingResult) =
        if (bindingResult.hasErrors()) {
            throw BadRequestExceptioin()
        } else occurrenceService.createOccurrence(occurrenceRequest)

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/occurrence/ticket-number/{ticketNumber}")
    @ApiOperation(value = "Obtaing occurrence by TicketNumber")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 200, message = "Return Occurence"),
            ApiResponse(code = 404, message = "Occurrence Not Found")
    ))
    fun findByTicketNumber(@PathVariable ticketNumber: String) =
        occurrenceService.getOccurrenceByTicketNumber(ticketNumber) ?: throw NotFoundExeption("Occurrence not found")

    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtaing occurrence by Id")
    @GetMapping("/api/occurrence/id/{id}")
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 200, message = "Return Occurence"),
            ApiResponse(code = 404, message = "Occurrence Not Found")
    ))
    fun findByIdr(@PathVariable id: Long) =
            occurrenceService.getOccurrenceById(id) ?: throw NotFoundExeption("Occurrence not found")
}