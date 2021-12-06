package ca.sharipov.kotlinweather.data.model.onecall

import ca.sharipov.kotlinweather.data.model.common.Rain
import ca.sharipov.kotlinweather.data.model.common.Snow
import ca.sharipov.kotlinweather.data.model.common.Weather
import kotlinx.serialization.Serializable

@Serializable
data class Hourly(
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val feels_like: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Rain? = null,
    val snow: Snow? = null,
    val temp: Double,
    val uvi: Double,
    val visibility: Int,
    val weather: List<Weather>,
    val wind_deg: Int,
    val wind_gust: Double? = null,
    val wind_speed: Double
)