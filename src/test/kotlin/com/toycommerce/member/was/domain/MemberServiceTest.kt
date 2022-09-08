package com.toycommerce.member.was.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class MemberServiceTest{
    @Mock
    lateinit var memberStore: MemberStore
    @InjectMocks
    lateinit var memberService: MemberService

    fun `회원가입을 한다`() {
        val member = memberService.register("가입")
        Assertions.assertThat(member.nickName).isEqualTo("가입")
        print(member.id)
    }
}