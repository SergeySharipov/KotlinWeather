package ca.sharipov.kotlinweather.data.model.onecall

import kotlinx.serialization.Serializable

@Serializable
data class OneCallResponse(
    val alerts: List<Alert>,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezone_offset: Int
)