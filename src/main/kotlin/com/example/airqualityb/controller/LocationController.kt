package com.example.airqualityb.controller

import com.example.airqualityb.dto.WeatherAirData
import com.example.airqualityb.service.LocationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/air-quality")
class LocationController(private val locationService: LocationService) {

    @GetMapping("/countries")
    fun getCountries() = locationService.getCountries()

    @GetMapping("/states/{country}")
    fun getStates(@PathVariable country: String) = locationService.getStates(country)

    @GetMapping("/weather")
    fun getWeather(
        @RequestParam city: String,
        @RequestParam state: String,
        @RequestParam country: String
    ): WeatherAirData {
        return locationService.getWeatherData(city, state, country)
    }
}