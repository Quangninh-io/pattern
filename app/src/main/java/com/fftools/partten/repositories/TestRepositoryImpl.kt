package com.fftools.partten.repositories

import android.content.Context

class TestRepositoryImpl(private val context: Context) : TestRepository {
    override suspend fun test(name: String): Int? {
        return name.length
    }
}