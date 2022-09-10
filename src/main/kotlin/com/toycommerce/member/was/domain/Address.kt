package com.toycommerce.member.was.domain

import javax.persistence.Embeddable

@Embeddable
data class Address(
    val zipCode : String,
    val addressDetail: String,
)
