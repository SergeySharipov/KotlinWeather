package ca.sharipov.kotlinweather.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    val lat: Double,
    val lon: Double
)