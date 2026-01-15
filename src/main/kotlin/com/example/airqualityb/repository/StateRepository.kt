package com.example.airqualityb.repository

import com.example.airqualityb.entity.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.airqualityb.entity.State
import java.util.Optional

@Repository
interface StateRepository : JpaRepository<State, String> {
    // Esto es para buscar los estados de un país específico
    fun findByCountry(country: Country): List<State>

    fun findByName(name: String): Optional<State>
}