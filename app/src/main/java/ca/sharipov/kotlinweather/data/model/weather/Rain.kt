package ca.sharipov.kotlinweather.data.model.weather

import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    val `1h`: Double
)