package com.toycommerce.member.was.domain

import com.toycommerce.member.was.dto.*

interface MemberDomainService {
    fun registerSeller(command: SellerRegistrationCommand): SellerRegistrationInfo
    fun registerBuyer(command: BuyerRegistrationCommand): BuyerRegistrationInfo
    fun registerAdmin(command: AdminRegistrationCommand): AdminRegistrationInfo
}