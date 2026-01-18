package com.example.airqualityb.dto

import com.fasterxml.jackson.annotation.JsonProperty


// Respuestas genéricas Finalidad no repetir código, todos los endpoints de IQAir responden Status, Data
data class IQAirResponse<T> (
    val status: String,
    val data: T
)

// Datos específicos
data class CountryData(val country: String)
data class StateData(val state: String)
data class CityData(val city: String)

// Datos del Clima y Aire
data class WeatherAirData(
    val city: String,
    val state: String,
    val country: String,
    @JsonProperty("current")
    val currentData: CurrentData
)

data class CurrentData(
    val pollution: PollutionData,
    val weather: WeatherDTO,
)

data class PollutionData(
    val ts: String,
    val aqius: Int,
    val mainus: String
)

data class WeatherDTO(
    val tp: Int,
    val ic: String,
    val hu: Int,
    val ws: Double,
)