package com.example.airqualityb.controller

import com.example.airqualityb.dto.WeatherAirData
import com.example.airqualityb.entity.City
import com.example.airqualityb.service.LocationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/air-quality")
@Tag(name = "Calidad del Aire", description = "Endpoints para consultar datos climáticos Clima y Calidad de Aire")
class LocationController(private val locationService: LocationService) {

    @Operation(summary = "Obtener paises admitidos", description = "Retorna paises admitidos para la lectura de datos climáticos en tiempo real.")
    @GetMapping("/countries")
    fun getCountries() = locationService.getCountries()

    @Operation(summary = "Obtener estados de un país especifico", description = "Retorna estados de un pais admitido.")
    @GetMapping("/states/{country}")
    fun getStates(@PathVariable country: String) = locationService.getStates(country)

    @Operation(summary = "Obtener ciudades pertenecientes a un estado dentro de un pais especifico.", description = "Retorna todas las ciudades pertenecientes a un estado especifico.")
    @GetMapping("/city/{country}/{state}")
    fun getCity(@PathVariable country: String, @PathVariable state: String) = locationService.getCities(country,state)

    @Operation(summary = "Obtener datos climáticos en tiempo real.", description = "Retorna datos climáticos en tiempo real de una ciudad especifica.")
    @GetMapping("/weather")
    fun getWeather(
        @RequestParam city: String,
        @RequestParam state: String,
        @RequestParam country: String
    ): WeatherAirData {
        return locationService.getWeatherData(city, state, country)
    }
}