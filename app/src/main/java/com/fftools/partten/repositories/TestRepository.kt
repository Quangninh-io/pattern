package com.fftools.partten.repositories

interface TestRepository {
    suspend fun test(a: Int, b: Int): Int?
}