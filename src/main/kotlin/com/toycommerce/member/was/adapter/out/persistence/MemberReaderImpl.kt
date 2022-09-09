package com.toycommerce.member.was.adapter.out.persistence

import com.toycommerce.member.was.application.port.out.MemberReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberReaderImpl: MemberReader {
    @Autowired
    private lateinit var memberJpaRepository: MemberJpaRepository
}