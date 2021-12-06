package ca.sharipov.kotlinweather.data

import ca.sharipov.kotlinweather.data.model.onecall.OneCallResponse
import ca.sharipov.kotlinweather.data.model.weather.WeatherResponse
import ca.sharipov.kotlinweather.util.Resource

interface MainRepository {

    suspend fun getWeatherResponse(lat: Double, lon: Double): Resource<WeatherResponse>

    suspend fun getOneCallResponse(lat: Double, lon: Double): Resource<OneCallResponse>
}