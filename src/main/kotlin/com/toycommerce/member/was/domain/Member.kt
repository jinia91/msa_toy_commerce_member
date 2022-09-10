package com.toycommerce.member.was.domain

import com.toycommerce.member.shared.domain.BasicEntity
import com.toycommerce.member.shared.exception.BadRequestException
import java.io.Serializable
import javax.persistence.*
import kotlin.jvm.Transient

/**
 * 계정 엔티티 추상 클래스
 *
 * 동일 repo로 관리하되, 별개 클래스에 영속화하는 전략(table_per_class)
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "role")
abstract class Member internal constructor(
    @EmbeddedId
    val id: MemberId,

    /**
     * 유효성 검증을 위한 파라미터
     */
    rawPwd: String,

    @Column(name = "pwd", length = 20, nullable = false)
    var pwd: String,

    @Column(name = "nick_name", length = 10)
    var nickName: String,

    @Column(length = 20, unique = true)
    var email: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    val role: Role,
): BasicEntity() {
    enum class Role{
        ADMIN,
        SELLER,
        BUYER
    }

    /**
     * 엔티티 최초 생성시 공통 검증
     */
    init {
        if (!MemberSpecification.validateRawPwd(rawPwd)) throw BadRequestException()
        if (!MemberSpecification.validateEmail(email)) throw BadRequestException()
    }
    /**
     * 준영속 체크를 피하기 위한 getId() 오버라이딩
     */
    override fun getId(): Serializable {
        return id
    }
}