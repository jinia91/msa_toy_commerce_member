package com.toycommerce.member.was.adapter.out.persistence

import com.toycommerce.member.shared.id_generator.IdGenerator
import com.toycommerce.member.was.domain.Member
import com.toycommerce.member.was.domain.MemberId
import com.toycommerce.member.was.application.port.out.MemberStore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberStoreImpl: MemberStore {
    @Autowired
    private lateinit var memberJpaRepository: MemberJpaRepository
    @Autowired
    private lateinit var idGenerator: IdGenerator

    override fun nextId(): MemberId {
        return MemberId(idGenerator.generate())
    }

    override fun store(member: Member) {
        memberJpaRepository.save(member)
    }
}