package com.toycommerce.member.was.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("SELLER")
class Seller internal constructor(
    id: MemberId,
    rawPwd: String,
    pwd: String,
    nickName: String,
    email: String,
): Member(id, rawPwd, pwd, nickName, email, Role.SELLER){
    companion object{
        fun newOne(id: MemberId, rawPwd: String, pwd: String, nickName: String, email: String): Seller
        = Seller(id, rawPwd, pwd, nickName, email)
    }
}