package com.toycommerce.member.was.domain

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("BUYER")
class Buyer internal constructor(
    id: MemberId,
    pwd: String,
    nickName: String,
    email: String,
    var address: String,
): Member(id, pwd, nickName, email, Member.Role.BUYER){
    var point = 0
}