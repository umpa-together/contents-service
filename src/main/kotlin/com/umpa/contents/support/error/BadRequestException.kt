package com.umpa.user.support.error

data class BadRequestException(
    val errorType: ErrorType = DefaultErrorType.BAD_REQUEST
) : RuntimeException(errorType.message)
