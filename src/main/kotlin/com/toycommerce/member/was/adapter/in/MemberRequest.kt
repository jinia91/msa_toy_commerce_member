package com.toycommerce.member.was.adapter.`in`

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SellerRegistrationRequest(
    @ApiModelProperty(required = true, notes = "이메일")
    @field:NotBlank
    @field:Email
    val email: String,

    @ApiModelProperty(required = true, notes = "닉네임")
    @field:NotBlank
    @field:Size(min = 4, max = 10)
    val nickName: String,

    @ApiModelProperty(required = true, notes = "비밀번호")
    @field:NotBlank
    @field:Pattern(
        regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[\$@\$!%*#?&])[A-Za-z\\d\$@\$!%*#?&]{8,20}\$",
        message = "8자 이상~20자 이하, 영문 숫자 특수문자가 반드시 하나 이상 포함되어야합니다"
    )
    val pwd: String,
)