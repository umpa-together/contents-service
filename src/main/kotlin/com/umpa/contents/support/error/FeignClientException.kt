package com.umpa.contents.support.error

import com.umpa.user.support.error.DefaultErrorType

data class FeignClientException(
    override val message: String? = DefaultErrorType.INTERNAL_SERVER_ERROR.message,
) : RuntimeException(message)
