package com.toycommerce.member.was.adapter.`in`.http

import com.toycommerce.member.config.SwaggerConfig
import com.toycommerce.member.was.application.port.`in`.MemberUseCase
import com.toycommerce.member.was.dto.AdminRegistrationCommand
import com.toycommerce.member.was.dto.BuyerRegistrationCommand
import com.toycommerce.member.was.dto.SellerRegistrationCommand
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Api(tags = [SwaggerConfig.ALL, SwaggerConfig.MEMBER])
@RequestMapping("/member-service")
class MemberResource {
    @Autowired
    private lateinit var memberUseCase: MemberUseCase

    @PostMapping("/seller")
    fun registerSeller(
        @RequestBody @Validated request: SellerRegistrationRequest,
    ) {
        return request.run {
            SellerRegistrationCommand(email, nickName, pwd)
        }.run {
            memberUseCase.registerSeller(this)
        }.run {
            SellerRegistrationResponse(id, email)
        }.run {
            ResponseEntity(this, HttpStatus.OK)
        }
    }

    @PostMapping("/buyer")
    fun registerSeller(
        @RequestBody @Validated request: BuyerRegistrationRequest,
    ) {
        return request.run {
            BuyerRegistrationCommand(email, nickName, pwd, zipCode, address)
        }.run {
            memberUseCase.registerBuyer(this)
        }.run {
            BuyerRegistrationResponse(id, email)
        }.run {
            ResponseEntity(this, HttpStatus.OK)
        }
    }

    @PostMapping("/admin")
    fun registerSeller(
        @RequestBody @Validated request: AdminRegistrationRequest,
    ) {
        return request.run {
            AdminRegistrationCommand(email, nickName, pwd)
        }.run {
            memberUseCase.registerAdmin(this)
        }.run {
            AdminRegistrationResponse(id, email)
        }.run {
            ResponseEntity(this, HttpStatus.OK)
        }
    }
}