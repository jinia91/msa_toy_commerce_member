package com.toycommerce.member.was.domain

import com.toycommerce.member.shared.domain.BasicEntity
import com.toycommerce.member.shared.exception.BadRequestException
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.Email

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "role")
abstract class Member internal constructor(
    @EmbeddedId
    val id: MemberId,

    @Column(name = "pwd", length = 20, nullable = false)
    var pwd: String,

    @Column(name = "nick_name", length = 10)
    var nickName: String,

    @Column(length = 20, unique = true)
    @Email
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
    companion object{
        val pwdRegex: Regex = Regex( "(?=.*[A-Za-z])(?=.*\\d)(?=.*[\$@\$!%*#?&])[A-Za-z\\d\$@\$!%*#?&]{8,20}\$")
        val mailRegex: Regex = Regex( "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$")
    }

    init {
        if(!pwdRegex.matches(pwd)) throw BadRequestException("member.pwd")
        if(!mailRegex.matches(email)) throw BadRequestException("member.email")
    }

    override fun getId(): Serializable {
        return id
    }
}