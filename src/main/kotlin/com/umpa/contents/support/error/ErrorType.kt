package com.umpa.user.support.error

import org.springframework.http.HttpStatus

interface ErrorType {
    val message: String
    val statusCode: HttpStatus
}
