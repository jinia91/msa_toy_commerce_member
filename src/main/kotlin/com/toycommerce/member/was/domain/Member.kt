package com.toycommerce.member.was.domain

import com.toycommerce.member.shared.domain.BasicEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "member")
class Member(
    @EmbeddedId
    val id: MemberId,

    @Column(name = "nick_name", length = 10)
    var nickName: String? = null,
): BasicEntity() {
    override fun getId(): Serializable {
        return id
    }
}