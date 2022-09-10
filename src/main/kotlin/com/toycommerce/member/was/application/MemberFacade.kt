package com.toycommerce.member.was.application

import com.toycommerce.member.was.application.port.`in`.MemberUseCase
import com.toycommerce.member.was.dto.*
import org.springframework.stereotype.Component

/**
 * adapter에서 최초 진입하는 최상단 Usecase Facade
 *
 * service들의 오케스트레이션만을 하며, 자체 비즈니스 로직은 없다
 */
@Component
class MemberFacade: MemberUseCase {
    private lateinit var memberService: MemberService

    override fun registerSeller(command: SellerRegistrationCommand): SellerRegistrationInfo {
        return memberService.registerSeller(command)
    }

    override fun registerBuyer(command: BuyerRegistrationCommand): BuyerRegistrationInfo {
        return memberService.registerBuyer(command)
    }

    override fun registerAdmin(command: AdminRegistrationCommand): AdminRegistrationInfo {
        return memberService.registerAdmin(command)
    }
}