package com.toycommerce.member.config

import com.toycommerce.member.shared.id_generator.IdGenerator
import com.toycommerce.member.shared.id_generator.ServerIdAllocator
import com.toycommerce.member.shared.id_generator.SnowFlake53StrategyIdGeneratorImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class IdGeneratorConfig {
    companion object{
        const val MACHINE_SEQUENCE_BIT_SIZE = 7
    }

    @Bean
    fun idGenerator(allocator: ServerIdAllocator): IdGenerator {
        val serverId = allocator.allocate()
        return SnowFlake53StrategyIdGeneratorImpl(serverId, MACHINE_SEQUENCE_BIT_SIZE)
    }
}