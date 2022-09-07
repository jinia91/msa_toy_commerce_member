package com.toycommerce.shared.id_generator

interface ServerIdAllocator {
    fun allocate(): Int
}