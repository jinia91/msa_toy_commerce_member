package com.toycommerce.member.was.adapter.`in`

import io.swagger.annotations.ApiModelProperty
import org.jetbrains.annotations.NotNull

data class SellerRegistrationRequest(
    @ApiModelProperty(required = true, notes = "이메일")
    @NotNull
    val email: String,

    @ApiModelProperty(required = true, notes = "닉네임")
    @NotNull
    val nickName: String,

    @NotNull
    @ApiModelProperty(required = true, notes = "비밀번호")
    val pwd: String,
)