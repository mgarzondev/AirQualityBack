package com.example.airqualityb.client

import com.example.airqualityb.dto.CityData
import com.example.airqualityb.dto.CountryData
import com.example.airqualityb.dto.IQAirResponse
import com.example.airqualityb.dto.StateData
import com.example.airqualityb.dto.WeatherAirData
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "airQualityBClient", url = "https://api.airvisual.com/v2")
interface IQAirClient {
    @GetMapping("/countries")
    fun getCountries(@RequestParam("key") apiKey: String): IQAirResponse<List<CountryData>>

    @GetMapping("/states")
    fun getStates(
        @RequestParam("country") country: String,
        @RequestParam("key") apiKey: String): IQAirResponse<List<StateData>>

    @GetMapping("/cities")
    fun getCities(
        @RequestParam("state") state: String,
        @RequestParam("country") country: String,
        @RequestParam("key") apiKey: String
    ): IQAirResponse<List<CityData>>

    @GetMapping("/city")
    fun getCityData(
        @RequestParam("city") city: String,
        @RequestParam("state") state: String,
        @RequestParam("country") country: String,
        @RequestParam("key") apiKey: String
    ): IQAirResponse<WeatherAirData>
}

