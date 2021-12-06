package ca.sharipov.kotlinweather.data

import ca.sharipov.kotlinweather.data.model.onecall.OneCallResponse
import ca.sharipov.kotlinweather.data.model.weather.WeatherResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class WeatherApi @Inject constructor(private val client: HttpClient) {

    suspend fun getWeatherResponse(): WeatherResponse =
        client.get("/data/2.5/weather")

    suspend fun getOneCallResponse(): OneCallResponse =
        client.get("data/2.5/onecall?exclude=current,minutely")
}