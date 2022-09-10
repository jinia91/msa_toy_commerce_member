package com.toycommerce.member.was.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("ADMIN")
class Admin internal constructor(
    id: MemberId,
    rawPwd: String,
    pwd: String,
    nickName: String,
    email: String,
): Member(id, rawPwd, pwd, nickName, email, Member.Role.ADMIN) {
    companion object {
        fun newOne(id: MemberId, rawPwd: String, pwd: String, nickName: String, email: String): Admin {
            return Admin(id, rawPwd, pwd, nickName, email)
        }
    }
}