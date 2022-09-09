package com.toycommerce.member.was.domain

import com.toycommerce.member.was.application.MemberService
import com.toycommerce.member.was.application.port.out.MemberStore
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
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

    @Test
    fun `회원가입을 한다`() {
        val member = memberService.registerSeller("가입")
        Assertions.assertThat(member.nickName).isEqualTo("가입")
    }
}