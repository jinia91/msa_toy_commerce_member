package com.toycommerce.member.was.adapter.out.persistence

import com.toycommerce.member.was.domain.Member
import com.toycommerce.member.was.domain.MemberId
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<Member, MemberId>{
}