package ca.sharipov.kotlinweather.repository

import ca.sharipov.kotlinweather.data.WeatherApi
import ca.sharipov.kotlinweather.data.model.onecall.OneCallResponse
import ca.sharipov.kotlinweather.data.model.weather.WeatherResponse
import ca.sharipov.kotlinweather.util.Resource
import javax.inject.Inject


class DefaultMainRepository @Inject constructor(
    private val api: WeatherApi
) : MainRepository {

    override suspend fun getWeatherResponse(): Resource<WeatherResponse> {
        return try {
            val response = api.getWeatherResponse()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    override suspend fun getOneCallResponse(): Resource<OneCallResponse> {
        return try {
            val response = api.getOneCallResponse()
            Resource.Success(response)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}