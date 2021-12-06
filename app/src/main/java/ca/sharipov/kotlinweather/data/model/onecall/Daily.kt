package ca.sharipov.kotlinweather.data.model.onecall

import ca.sharipov.kotlinweather.data.model.common.Weather
import kotlinx.serialization.Serializable

@Serializable
data class Daily(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: FeelsLike,
    val humidity: Int,
    val moon_phase: Double,
    val moonrise: Int,
    val moonset: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double? = null,
    val snow: Double? = null,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val uvi: Double,
    val weather: List<Weather>,
    val wind_deg: Int,
    val wind_gust: Double? = null,
    val wind_speed: Double
)