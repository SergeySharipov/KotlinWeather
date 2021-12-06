package ca.sharipov.kotlinweather.data.model.common

import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    val `1h`: Double
)