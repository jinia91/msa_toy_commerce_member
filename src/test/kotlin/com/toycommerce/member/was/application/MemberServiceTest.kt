package com.toycommerce.member.was.application

import com.toycommerce.member.shared.exception.BadRequestException
import com.toycommerce.member.was.domain.MemberId
import com.toycommerce.member.was.application.port.`in`.SellerRegistrationCommand
import com.toycommerce.member.was.application.port.`in`.SellerRegistrationInfo
import com.toycommerce.member.was.application.port.out.MemberReader
import com.toycommerce.member.was.application.port.out.MemberStore
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
internal class MemberServiceTest{
    @Mock
    lateinit var memberStore: MemberStore
    @Mock
    lateinit var memberReader: MemberReader
    @InjectMocks
    lateinit var sut: MemberService

    @Test
    fun `판매자를 등록 한다 - success`() {
        //given
        val command = SellerRegistrationCommand(
            "em2ail@dfsv.com",
            "닉네임",
            "pwd123!!"
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        //when
        val resultInfo : SellerRegistrationInfo = sut.registerSeller(command)
        //then
        Assertions.assertThat(resultInfo.id).isEqualTo(1L)
        Assertions.assertThat(resultInfo.email).isEqualTo(command.email)
    }

    @Test
    fun `판매자를 등록 한다 - fail - invalid email`() {
        //given
        val command = SellerRegistrationCommand(
            "em2ail",
            "닉네임",
            "pwd123!!"
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        //when
        assertFailsWith<BadRequestException> {
            sut.registerSeller(command)
        }
    }

    @Test
    fun `판매자를 등록 한다 - fail - invalid pwd`() {
        //given
        val command = SellerRegistrationCommand(
            "em2ail@dfsv.com",
            "닉네임",
            "pwd"
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        //when
        assertFailsWith<BadRequestException> {
            sut.registerSeller(command)
        }
    }
}