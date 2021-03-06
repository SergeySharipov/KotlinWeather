package ca.sharipov.kotlinweather.data.model.weather

import ca.sharipov.kotlinweather.data.model.common.Rain
import ca.sharipov.kotlinweather.data.model.common.Snow
import ca.sharipov.kotlinweather.data.model.common.Weather
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain? = null,
    val snow: Snow? = null,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)