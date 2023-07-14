package com.fftools.partten.repositories.retrofit

import com.fftools.partten.models.GunData
import retrofit2.http.GET

interface RetrofitService {
    @GET("file_ffmax_gun.json")
    suspend fun getGunData(): List<GunData>
}