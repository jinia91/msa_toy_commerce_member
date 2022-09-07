package com.toycommerce.member.shared.id_generator

interface ServerIdAllocator {
    fun allocate(): Int
}