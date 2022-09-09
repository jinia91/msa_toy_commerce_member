package com.toycommerce.member.was.application

import com.toycommerce.member.was.application.port.out.MemberReader
import com.toycommerce.member.was.application.port.out.MemberStore
import com.toycommerce.member.was.domain.Member
import org.springframework.stereotype.Service

@Service
class MemberService(
    private var memberStore: MemberStore,
    private var memberReader: MemberReader,
) {
    fun register(name: String): Member {
        val memberId = memberStore.nextId()
        val member = Member(memberId, name)
        memberStore.store(member)
        return member
    }
}