package com.toycommerce.member.was.domain

import com.toycommerce.member.shared.exception.BadRequestException

internal object MemberSpecification{
    private val pwdRegex: Regex = Regex( "(?=.*[A-Za-z])(?=.*\\d)(?=.*[\$@\$!%*#?&])[A-Za-z\\d\$@\$!%*#?&]{8,20}\$")
    private val emailRegex: Regex = Regex( "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")

    fun validateRawPwd(pwd: String): Boolean {
        return pwdRegex.matches(pwd)
    }

    fun validateEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }

    internal fun getInstance(): MemberSpecification = this
}