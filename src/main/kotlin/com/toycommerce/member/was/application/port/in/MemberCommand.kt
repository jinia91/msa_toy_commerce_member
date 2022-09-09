package com.toycommerce.member.was.application.port.`in`

data class SellerRegistrationCommand(
    val email: String,
    val nickName: String,
    val pwd: String,
) {
}