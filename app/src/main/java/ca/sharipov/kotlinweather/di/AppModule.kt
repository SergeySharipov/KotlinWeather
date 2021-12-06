package ca.sharipov.kotlinweather.di

import android.util.Log
import ca.sharipov.kotlinweather.BuildConfig
import ca.sharipov.kotlinweather.data.WeatherApi
import ca.sharipov.kotlinweather.repository.DefaultMainRepository
import ca.sharipov.kotlinweather.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Singleton

private const val TIME_OUT = 60_000
private const val BASE_URL = "https://api.openweathermap.org/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideWeatherApi(): HttpClient = HttpClient(Android) {

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }

            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
            }
        }

        val params = Parameters.build {
            append("appid", BuildConfig.API_KEY)
            append("lang", "en")
            append("units", "metric")
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            url.takeFrom(URLBuilder().takeFrom(BASE_URL).apply {
                encodedPath += url.encodedPath
            }).parameters.appendAll(params)
        }
    }

    @Singleton
    @Provides
    fun provideMainRepository(api: WeatherApi): MainRepository = DefaultMainRepository(api)

}