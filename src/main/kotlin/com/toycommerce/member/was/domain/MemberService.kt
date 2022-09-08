package com.toycommerce.member.was.domain

import org.springframework.stereotype.Service

@Service
class MemberService(
    private var memberStore: MemberStore,
    private var memberReader: MemberReader,
) {
    fun register(name: String): Member{
        val memberId = memberStore.nextId()
        val member = Member(memberId, name)
        memberStore.store(member)
        return member
    }
}