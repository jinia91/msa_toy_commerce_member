package com.toycommerce.shared.id_generator

import com.toycommerce.member.config.IdGeneratorConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.support.TransactionTemplate
import kotlin.math.pow

/**
 * 서버 구동시 머신 고유 ID 할당기
 *
 * 최초 서버 구동시 DB에 스키마가 존재하지 않는다면
 *
 * sql: `create table machine_sequence(sequence bigint);` 필요
 */
@Component
class JdbcServerIdAllocator(
    @Autowired private val jdbcTemplate: JdbcTemplate,
    @Autowired private val transactionManager: PlatformTransactionManager
) : ServerIdAllocator {
    private val machineSequenceBitSize: Int = IdGeneratorConfig.MACHINE_SEQUENCE_BIT_SIZE

    override fun allocate(): Int {
        val transactionTemplate =
            TransactionTemplate(transactionManager)
        transactionTemplate.isolationLevel = TransactionDefinition.ISOLATION_READ_COMMITTED
        transactionTemplate.propagationBehavior = TransactionDefinition.PROPAGATION_REQUIRED

        return transactionTemplate.execute {
            val update = "UPDATE machine_sequence SET sequence = sequence + 1"
            jdbcTemplate.update(update)
            val select = "SELECT sequence FROM machine_sequence"
            val nextId: Int = try {
                jdbcTemplate.queryForObject(select, Integer::class.java)!!.toInt()
            } catch (e: EmptyResultDataAccessException) {
                jdbcTemplate.update("INSERT INTO machine_sequence VALUES (1)")
                1
            }
            val sequenceModular: Int = 2.0.pow(machineSequenceBitSize).toInt();
            return@execute nextId % sequenceModular;
        }!!.toInt()
    }
}