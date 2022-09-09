package com.toycommerce.member.was.adapter.`in`

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class SellerRegistrationRequest(
    @ApiModelProperty(required = true, notes = "이메일")
    @field:NotBlank
    @field:Email
    val email: String,

    @ApiModelProperty(required = true, notes = "닉네임")
    @field:NotBlank
    val nickName: String,

    @ApiModelProperty(required = true, notes = "비밀번호")
    @field:NotBlank
    val pwd: String,
)