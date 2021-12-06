package ca.sharipov.kotlinweather.data

import ca.sharipov.kotlinweather.data.model.onecall.OneCallResponse
import ca.sharipov.kotlinweather.data.model.weather.WeatherResponse
import ca.sharipov.kotlinweather.data.remote.WeatherApi
import ca.sharipov.kotlinweather.util.Resource
import javax.inject.Inject


class DefaultMainRepository @Inject constructor(
    private val api: WeatherApi
) : MainRepository {

    override suspend fun getWeatherResponse(lat: Double, lon: Double): Resource<WeatherResponse> {
        return try {
            val response = api.getWeatherResponse(lat, lon)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun getOneCallResponse(lat: Double, lon: Double): Resource<OneCallResponse> {
        return try {
            val response = api.getOneCallResponse(lat, lon)
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}