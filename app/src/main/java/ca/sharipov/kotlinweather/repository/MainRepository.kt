package ca.sharipov.kotlinweather.repository

import ca.sharipov.kotlinweather.data.model.onecall.OneCallResponse
import ca.sharipov.kotlinweather.data.model.weather.WeatherResponse
import ca.sharipov.kotlinweather.util.Resource

interface MainRepository {

    suspend fun getWeatherResponse(): Resource<WeatherResponse>

    suspend fun getOneCallResponse(): Resource<OneCallResponse>
}