package com.fftools.partten.repositories

interface TestRepository {
    suspend fun test(name: String): Int?
}