package br.com.novare.adapters.config

import br.com.novare.entities.exception.BusinessException
import br.com.novare.entities.exception.ExceptionRequestOutput
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler
    fun handleIllegalStateException(ex: BusinessException): ResponseEntity<ExceptionRequestOutput> {

        val errorMessage = ExceptionRequestOutput(
            ex.status,
            ex.message
        )

        val httpStatus = HttpStatus.valueOf(ex.status)

        return ResponseEntity(errorMessage, httpStatus)
    }
}
