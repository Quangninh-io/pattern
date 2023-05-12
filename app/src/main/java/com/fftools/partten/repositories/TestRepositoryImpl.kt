package com.fftools.partten.repositories

import android.content.Context

class TestRepositoryImpl(private val context: Context) : TestRepository {
    override suspend fun test(a: Int, b: Int): Int? {
        return a+b
    }
}