package com.nasza.latihanparsingsuperheroapi.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nasza.latihanparsingsuperheroapi.model.SuperHero
import com.nasza.latihanparsingsuperheroapi.repository.SuperHeroRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = SuperHeroRepository()
    val superHero = MutableLiveData<SuperHero?>()
    val error = MutableLiveData<String?>()

    init {
        fetchSuperHero("43")
    }

    private fun fetchSuperHero(id: String) {
        viewModelScope.launch {
            val result = repository.getSuperHero(id)
            if (result != null) {
                Log.d("MainViewModel", "SuperHero: $result")
                superHero.value = result
            } else {
                error.value = "Failed to load superhero data"
            }
        }
    }
}