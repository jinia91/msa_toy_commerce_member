package com.toycommerce.member.shared.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.domain.Persistable
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BasicEntity: Persistable<Serializable> {
    @CreatedDate
    @Column(updatable = false)
    var createdAt: LocalDateTime? = null
        private set

    @LastModifiedDate
    var updatedAt: LocalDateTime? = null
        private set

    override fun isNew(): Boolean {
        return createdAt == null
    }
}