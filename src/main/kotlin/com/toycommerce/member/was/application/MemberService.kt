package com.toycommerce.member.was.application

import com.toycommerce.member.shared.exception.BadRequestException
import com.toycommerce.member.was.application.port.out.MemberReader
import com.toycommerce.member.was.application.port.out.MemberStore
import com.toycommerce.member.was.domain.*
import com.toycommerce.member.was.dto.*
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class MemberService: MemberDomainService {
    private lateinit var memberStore: MemberStore
    private lateinit var memberReader: MemberReader
    private lateinit var passwordEncoder: PasswordEncoder
    @Transactional
    override fun registerSeller(command: SellerRegistrationCommand): SellerRegistrationInfo {
        return Seller.newOne(
            memberStore.nextId(),
            command.pwd,
            passwordEncoder.encode(command.pwd),
            command.nickName,
            command.email
        ).run {
                memberStore.store(this)
                SellerRegistrationInfo(this.id.id, this.email)
        }
    }

    override fun registerBuyer(command: BuyerRegistrationCommand): BuyerRegistrationInfo {
        return Buyer.newOne(
            memberStore.nextId(),
            command.pwd,
            passwordEncoder.encode(command.pwd),
            command.nickName,
            command.email,
            command.address
        ).run {
            memberStore.store(this)
            BuyerRegistrationInfo(this.id.id, this.email)
        }
    }

    override fun registerAdmin(command: AdminRegistrationCommand): AdminRegistrationInfo {
        return Admin.newOne(
            memberStore.nextId(),
            command.pwd,
            passwordEncoder.encode(command.pwd),
            command.nickName,
            command.email,
        ).run {
            memberStore.store(this)
            AdminRegistrationInfo(this.id.id, this.email)
        }
    }
}