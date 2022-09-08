package com.toycommerce.member.was.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Rollback(value = false)
class Test{
    @Autowired
    lateinit var memberService: MemberService

    @Test
    fun `회원가입을 한다`() {
        val member = memberService.register("가입")
        Assertions.assertThat(member.nickName).isEqualTo("가입")
        print(member.id)
    }
}