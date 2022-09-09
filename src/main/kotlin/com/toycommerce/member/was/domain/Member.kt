package com.toycommerce.member.was.domain

import com.toycommerce.member.shared.domain.BasicEntity
import java.io.Serializable
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "role")
abstract class Member internal constructor(
    @EmbeddedId
    val id: MemberId,

    @Column(name = "pwd", length = 50, nullable = false)
    var pwd: String,

    @Column(name = "nick_name", length = 10)
    var nickName: String,

    @Column(length = 250, unique = true)
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

    override fun getId(): Serializable {
        return id
    }
}