package com.umpa.user.support.error

data class ApplicationException(
    val errorType: ErrorType = DefaultErrorType.INTERNAL_SERVER_ERROR
) : RuntimeException(errorType.message)
