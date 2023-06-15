package com.fftools.partten.repositories.retrofit

import com.fftools.partten.models.GunData

class RetrofitRepositoryImpl(private val retrofitService: RetrofitService)  {
    suspend fun getGunData(): List<GunData> {
        return retrofitService.getGunData()
    }
}