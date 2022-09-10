package com.toycommerce.member.was.dto

import com.toycommerce.member.was.domain.Address

data class SellerRegistrationCommand(
    val email: String,
    val nickName: String,
    val pwd: String,
)

class BuyerRegistrationCommand(
    val email: String,
    val nickName: String,
    val pwd: String,
    zipCode: String,
    address: String,
) {
    val address: Address
    init {
        this.address = Address(zipCode, address)
    }
}

data class AdminRegistrationCommand(
    val email: String,
    val nickName: String,
    val pwd: String,
)