package ca.sharipov.kotlinweather.data.remote

import ca.sharipov.kotlinweather.data.model.onecall.OneCallResponse
import ca.sharipov.kotlinweather.data.model.weather.WeatherResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class WeatherApi @Inject constructor(private val client: HttpClient) {

    suspend fun getWeatherResponse(
        lat: Double,
        lon: Double
    ): WeatherResponse =
        client.get("data/2.5/weather?lat=$lat&lon=$lon")

    suspend fun getOneCallResponse(
        lat: Double,
        lon: Double
    ): OneCallResponse =
        client.get("data/2.5/onecall?lat=$lat&lon=$lon&exclude=current,minutely")
}