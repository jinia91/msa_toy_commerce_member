package com.toycommerce.member.was.application.port.`in`

interface MemberUseCase {
    fun register(command: MemberRegistrationCommand) : MemberRegistrationInfo
}