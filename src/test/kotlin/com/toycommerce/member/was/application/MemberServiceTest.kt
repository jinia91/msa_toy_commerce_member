package com.toycommerce.member.was.application

import com.toycommerce.member.shared.exception.BadRequestException
import com.toycommerce.member.was.domain.MemberId
import com.toycommerce.member.was.application.port.out.MemberReader
import com.toycommerce.member.was.application.port.out.MemberStore
import com.toycommerce.member.was.dto.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import org.springframework.security.crypto.password.PasswordEncoder
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
internal class MemberServiceTest{
    @Mock
    lateinit var memberStore: MemberStore
    @Mock
    lateinit var memberReader: MemberReader
    @Mock
    lateinit var passwordEncoder: PasswordEncoder
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
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
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
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
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
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        assertFailsWith<BadRequestException> {
            sut.registerSeller(command)
        }
    }

    @Test
    fun `구매자를 등록 한다 - success`() {
        //given
        val command = BuyerRegistrationCommand(
            "em2ail@dfsv.com",
            "닉네임",
            "pwd123!!",
            "zip",
            "ad",
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        val resultInfo = sut.registerBuyer(command)
        //then
        Assertions.assertThat(resultInfo.id).isEqualTo(1L)
        Assertions.assertThat(resultInfo.email).isEqualTo(command.email)
    }

    @Test
    fun `구매자를 등록 한다 - fail - invalid email`() {
        //given
        val command = BuyerRegistrationCommand(
            "em2ail",
            "닉네임",
            "pwd123!!",
            "zip",
            "ad",

            )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        assertFailsWith<BadRequestException> {
            sut.registerBuyer(command)
        }
    }

    @Test
    fun `구매자를 등록 한다 - fail - invalid pwd`() {
        //given
        val command = BuyerRegistrationCommand(
            "em2ail@dfsv.com",
            "닉네임",
            "pwd",
            "zip",
            "ad",

            )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        assertFailsWith<BadRequestException> {
            sut.registerBuyer(command)
        }
    }

    @Test
    fun `운영자를 등록 한다 - success`() {
        //given
        val command = AdminRegistrationCommand(
            "em2ail@dfsv.com",
            "닉네임",
            "pwd123!!"
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        val resultInfo  = sut.registerAdmin(command)
        //then
        Assertions.assertThat(resultInfo.id).isEqualTo(1L)
        Assertions.assertThat(resultInfo.email).isEqualTo(command.email)
    }

    @Test
    fun `운영자를 등록 한다 - fail - invalid email`() {
        //given
        val command = AdminRegistrationCommand(
            "em2ail",
            "닉네임",
            "pwd123!!"
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        assertFailsWith<BadRequestException> {
            sut.registerAdmin(command)
        }
    }

    @Test
    fun `운영자를 등록 한다 - fail - invalid pwd`() {
        //given
        val command = AdminRegistrationCommand(
            "em2ail@dfsv.com",
            "닉네임",
            "pwd"
        )
        whenever(memberStore.nextId()).thenReturn(MemberId(1L))
        whenever(passwordEncoder.encode(command.pwd)).thenReturn("encodedPwd")
        //when
        assertFailsWith<BadRequestException> {
            sut.registerAdmin(command)
        }
    }
}