package com.toycommerce.member.was.application.port.`in`

interface MemberUseCase {
    fun registerSeller(command: SellerRegistrationCommand) : MemberRegistrationInfo
}