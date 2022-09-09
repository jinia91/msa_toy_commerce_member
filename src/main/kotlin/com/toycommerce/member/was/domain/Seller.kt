package com.toycommerce.member.was.domain

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.PrimaryKeyJoinColumn

@Entity
@DiscriminatorValue("SELLER")
class Seller internal constructor(
    id: MemberId,
    pwd: String,
    nickName: String,
    email: String,
): Member(id, pwd, nickName, email, Member.Role.SELLER){
    companion object{
        fun newOne(id: MemberId, pwd: String, nickName: String, email: String): Seller = Seller(id, pwd, nickName, email)
    }
}