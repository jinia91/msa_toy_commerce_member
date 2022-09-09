package com.toycommerce.member.shared.exception


data class ErrorResponse(val error: Error) {
    constructor(type: String, message: String?) : this(Error(type, message))
}

data class Error(val type: String, val message: String?)