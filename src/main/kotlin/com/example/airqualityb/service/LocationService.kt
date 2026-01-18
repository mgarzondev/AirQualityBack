package com.example.airqualityb.service

import com.example.airqualityb.client.IQAirClient
import com.example.airqualityb.dto.WeatherAirData
import com.example.airqualityb.entity.City
import com.example.airqualityb.entity.Country
import com.example.airqualityb.entity.State
import com.example.airqualityb.repository.CityRepository
import com.example.airqualityb.repository.CountryRepository
import com.example.airqualityb.repository.StateRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class LocationService(
    private val countryRepository: CountryRepository,
    private val iqAirClient: IQAirClient,
    private val cityRepository: CityRepository,
    private val stateRepository: StateRepository) {

    @Value("\${iqair.api.key}")
    private lateinit var apiKey: String

    // Obtener Paises (Si no hay datos en la db se hace la llamada a la APi de IQAir)

    fun getCountries(): List<String> {
        val localCountries = countryRepository.findAll()
        // Si la tabla countries de la base de datos no está vacía retorna solamente la columna nombre de todas las filas.
        if (localCountries.isNotEmpty()) return localCountries.map { it.name }

        // Se hace la llamada a la APi de IQAir /countries
        val response = iqAirClient.getCountries(apiKey)

        val countries = response.data.map { Country(name = it.country) }
        countryRepository.saveAll(countries) // Se guardan los nombres de los paises en la db
        return countries.map { it.name }
    }

    // Obtener estados de un País

    fun getStates(countryName: String): List<String> {
        // Se verifica que el país exista en la base de datos
        val country = countryRepository.findByName(countryName).orElseThrow { Exception("País no encontrado") }

        // Busca todos los estados que pertenezcan al país y se retorna el nombre de todos los estados.
        val localStates = stateRepository.findByCountry(country)
        if (localStates.isNotEmpty()) return localStates.map { it.name }

        // Si no hay estados registrados para este país se piden a la APi de IQAir
        val response = iqAirClient.getStates(country.name, apiKey)
        val states = response.data.map { State(name = it.state, country = country) }
        stateRepository.saveAll(states) // Se guardan los nombres de los estados del país en la db
        return states.map { it.name }
    }

    // Obtener ciudades del estado y país
    fun getCities(countryName: String, stateName: String): List<String> {

        // Se verifica que el país y el estado existan en la bd
        val country = countryRepository.findByName(countryName).orElseThrow { Exception("País no encontrado") }
        val state = stateRepository.findByName(stateName).orElseThrow { Exception("Estado no encontrado") }

        val localCities = cityRepository.findByState(state)
        if (localCities.isNotEmpty()) return localCities.map { it.name }

        val response = iqAirClient.getCities(state.name, country.name, apiKey)
        val cities = response.data.map { City(name = it.city, state = state) }
        cityRepository.saveAll(cities)
        return cities.map {it.name}

    }

    // Obtener datos del clima

    fun getWeatherData(cityName: String, stateName: String, countryName: String): WeatherAirData {
        // Se llama directamente a la APi de IQAir para obtener datos del clima actuales en tiempo real
        val response = iqAirClient.getCityData(cityName,stateName,countryName, apiKey)
        return response.data
    }

}