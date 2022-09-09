package com.toycommerce.member.was.application

import com.toycommerce.member.was.application.port.`in`.SellerRegistrationCommand
import com.toycommerce.member.was.application.port.`in`.MemberRegistrationInfo
import com.toycommerce.member.was.application.port.`in`.MemberUseCase
import com.toycommerce.member.was.application.port.out.MemberReader
import com.toycommerce.member.was.application.port.out.MemberStore
import com.toycommerce.member.was.domain.Seller
import org.springframework.stereotype.Service

@Service
class MemberService(
    private var memberStore: MemberStore,
    private var memberReader: MemberReader,
) :MemberUseCase {
    override fun registerSeller(command: SellerRegistrationCommand): MemberRegistrationInfo {
        return Seller.newOne(memberStore.nextId(), command.pwd, command.nickName, command.email)
            .run {
                memberStore.store(this)
                MemberRegistrationInfo(this.id.id)
            }
    }
}