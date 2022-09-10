package com.toycommerce.member.was.dto

data class SellerRegistrationInfo(
    val id : Long,
    val email: String,
)

data class BuyerRegistrationInfo(
    val id : Long,
    val email: String,
)

data class AdminRegistrationInfo(
    val id : Long,
    val email: String,
)