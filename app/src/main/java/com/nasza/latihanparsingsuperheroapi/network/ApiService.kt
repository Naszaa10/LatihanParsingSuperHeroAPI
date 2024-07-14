package com.nasza.latihanparsingsuperheroapi.network

import com.nasza.latihanparsingsuperheroapi.model.SuperHero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{id}")
    suspend fun getSuperHero(@Path("id") id: String): Response<SuperHero>
}