package com.toycommerce.member.was.domain

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("ADMIN")
class Admin internal constructor(
    id: MemberId,
    pwd: String,
    nickName: String,
    email: String,
): Member(id,pwd, nickName, email, Member.Role.ADMIN)