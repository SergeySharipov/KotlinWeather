package ca.sharipov.kotlinweather.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    val all: Int
)