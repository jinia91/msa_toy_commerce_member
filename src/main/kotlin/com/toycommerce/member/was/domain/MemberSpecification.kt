package com.toycommerce.member.was.domain

/**
 * 도메인의 정책 응집을 위한 spec 싱글턴 객체
 *
 * - 애플리케이션, 도메인단의 유효성검증시
 */
object MemberSpecification{
    private val pwdRegex: Regex = Regex( "(?=.*[A-Za-z])(?=.*\\d)(?=.*[\$@\$!%*#?&])[A-Za-z\\d\$@\$!%*#?&]{8,20}\$")
    private val emailRegex: Regex = Regex( "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")

    fun validateRawPwd(pwd: String): Boolean {
        return pwdRegex.matches(pwd)
    }

    fun validateEmail(email: String): Boolean {
        return emailRegex.matches(email)
    }
}