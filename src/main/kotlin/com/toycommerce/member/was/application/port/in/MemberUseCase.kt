package com.toycommerce.member.was.application.port.`in`

import com.toycommerce.member.was.dto.*

interface MemberUseCase {
    fun registerSeller(command: SellerRegistrationCommand) : SellerRegistrationInfo
    fun registerBuyer(command: BuyerRegistrationCommand) : BuyerRegistrationInfo
    fun registerAdmin(command: AdminRegistrationCommand) : AdminRegistrationInfo
}