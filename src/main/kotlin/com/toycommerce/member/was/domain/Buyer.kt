package com.toycommerce.member.was.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Embedded
import javax.persistence.Entity

@Entity
@DiscriminatorValue("BUYER")
class Buyer internal constructor(
    id: MemberId,
    rawPwd: String,
    pwd: String,
    nickName: String,
    email: String,
    @Embedded
    var address: Address,
): Member(id, rawPwd, pwd, nickName, email, Member.Role.BUYER){
    var point = 0

    companion object {
        fun newOne(id: MemberId,rawPwd: String, pwd: String, nickName: String, email: String, address: Address): Buyer {
            return Buyer(id, rawPwd, pwd, nickName, email, address)
        }
    }
}