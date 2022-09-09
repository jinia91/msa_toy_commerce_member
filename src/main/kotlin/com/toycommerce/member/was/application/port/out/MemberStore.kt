package com.toycommerce.member.was.application.port.out

import com.toycommerce.member.was.domain.Member
import com.toycommerce.member.was.domain.MemberId

interface MemberStore {
    fun nextId(): MemberId
    fun store(member: Member)
}