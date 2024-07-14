package com.nasza.latihanparsingsuperheroapi.repository

import android.util.Log
import com.nasza.latihanparsingsuperheroapi.model.SuperHero
import com.nasza.latihanparsingsuperheroapi.network.RetrofitInstance

class SuperHeroRepository {
    private val apiService = RetrofitInstance.apiService

    suspend fun getSuperHero(id: String): SuperHero? {
        return try {
            val response = apiService.getSuperHero(id)
            if (response.isSuccessful) {
                response.body()?.also {
                    Log.d("SuperHeroRepository", "SuperHero: $it")
                }
            } else {
                Log.e("SuperHeroRepository", "Error: ${response.errorBody()?.string()}")
                null
            }
        } catch (e: Exception) {
            Log.e("SuperHeroRepository", "Exception: ${e.message}")
            null
        }
    }
}