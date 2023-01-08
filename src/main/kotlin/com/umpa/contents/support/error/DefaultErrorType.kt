package com.umpa.user.support.error

import org.springframework.http.HttpStatus

enum class DefaultErrorType(
    override val message: String,
    override val statusCode: HttpStatus
) : ErrorType {
    BAD_REQUEST("잘못된 요청입니다.", HttpStatus.BAD_REQUEST),

    INTERNAL_SERVER_ERROR("일시적인 서버 문제입니다.", HttpStatus.INTERNAL_SERVER_ERROR)
}
