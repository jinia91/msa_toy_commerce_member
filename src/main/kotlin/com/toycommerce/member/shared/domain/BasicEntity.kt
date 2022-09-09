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

/**
 * Audit과 snowflake ID 생성 전략을 위한 위한 기본 엔티티
 */
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

    /**
     * JPA가 엔티티가 새로운 객체인지 준영속/영속 객체인지 판단할때 사용하는 함수로, default는 id의 여부
     *
     * 만약 애플리케이션에서 ID를 만드는 전략을 취할경우 JPA는 ID가 존재하는 신규 엔티티에 대해 준영속객체로 인식하므로 이를 피하기 위해 isNew() 함수 재정의가 필요
     */
    override fun isNew(): Boolean {
        return createdAt == null
    }
}