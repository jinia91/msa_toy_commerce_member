package com.toycommerce.member.was.domain

interface MemberStore {
    fun nextId(): MemberId
    fun store(member: Member)
}