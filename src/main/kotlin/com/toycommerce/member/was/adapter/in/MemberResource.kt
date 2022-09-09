package com.toycommerce.member.was.adapter.`in`

import com.toycommerce.member.config.SwaggerConfig
import com.toycommerce.member.was.application.port.`in`.MemberUseCase
import com.toycommerce.member.was.application.port.`in`.SellerRegistrationCommand
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Api(tags = [SwaggerConfig.ALL, SwaggerConfig.MEMBER])
@RequestMapping("/member-service")
private class MemberResource {
    @Autowired
    lateinit var memberUseCase: MemberUseCase

    @PostMapping("/seller")
    fun registerSeller(@RequestBody @Validated request: SellerRegistrationRequest) {
        return request.run {
            SellerRegistrationCommand(email, nickName, pwd)
        }.run {
            memberUseCase.registerSeller(this)
        }.run {
            SellerRegistrationResponse(this.id)
        }.run {
            ResponseEntity(this, HttpStatus.OK)
        }
    }
}