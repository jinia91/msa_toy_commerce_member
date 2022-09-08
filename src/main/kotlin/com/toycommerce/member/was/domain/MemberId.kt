package com.toycommerce.member.was.domain

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
class MemberId(
    var id: Long
) : Serializable