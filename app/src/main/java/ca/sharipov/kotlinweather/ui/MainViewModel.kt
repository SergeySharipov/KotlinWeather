package ca.sharipov.kotlinweather.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.sharipov.kotlinweather.data.MainRepository
import ca.sharipov.kotlinweather.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    fun getOneCallWeather() {
        viewModelScope.launch {
            when (val ratesResponse = repository.getOneCallResponse(43.6647966, -79.346555)) {
                is Resource.Success -> {
                    Log.d("getOneCallWeather()", ratesResponse.data.toString())
                }
                is Resource.Error -> {
                    Log.e("getOneCallWeather()", ratesResponse.data.toString())
                }
            }
        }
    }

    fun getWeather() {
        viewModelScope.launch {
            when (val ratesResponse = repository.getWeatherResponse(43.6647966, -79.346555)) {
                is Resource.Success -> {
                    Log.d("getWeatherResponse()", ratesResponse.data.toString())
                }
                is Resource.Error -> {
                    Log.e("getWeatherResponse()", ratesResponse.data.toString())
                }
            }
        }
    }
}