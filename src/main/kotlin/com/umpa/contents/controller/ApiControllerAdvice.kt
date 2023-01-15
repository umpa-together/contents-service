package com.umpa.contents.controller

import com.umpa.contents.support.error.ErrorResponse
import com.umpa.contents.support.error.FeignClientException
import com.umpa.user.support.error.ApplicationException
import com.umpa.user.support.error.DefaultErrorType
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {
    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(ApplicationException::class)
    fun handleApplicationException(e: ApplicationException): ResponseEntity<ErrorResponse> {
        logger.info("ApplicationException: {}", e.message, e)
        return ResponseEntity.status(e.errorType.statusCode.value())
            .body(ErrorResponse(e.errorType.message, e.errorType.statusCode.value()))
    }

    @ExceptionHandler(FeignClientException::class)
    fun handleFeignException(e: FeignClientException): ResponseEntity<ErrorResponse> {
        logger.info("FeignException: {}", e.message, e)
        val errorType = DefaultErrorType.INTERNAL_SERVER_ERROR
        return ResponseEntity.status(errorType.statusCode.value())
            .body(ErrorResponse(errorType.message, errorType.statusCode.value()))
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(e: RuntimeException): ResponseEntity<ErrorResponse> {
        logger.info("RuntimeException: {}", e.message, e)
        val errorType = DefaultErrorType.INTERNAL_SERVER_ERROR
        return ResponseEntity.status(errorType.statusCode.value())
            .body(ErrorResponse(errorType.message, errorType.statusCode.value()))
    }
}
