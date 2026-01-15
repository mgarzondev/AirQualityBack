package com.example.airqualityb.repository

import com.example.airqualityb.entity.City
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.airqualityb.entity.State

@Repository
interface CityRepository : JpaRepository<City, String> {
    // Esto es para buscar las ciudades que pertenecen a un estado específico
    fun findByState(state: State): List<City>
}

