package com.example.airqualityb.repository

import com.example.airqualityb.entity.Country
import com.example.airqualityb.entity.State
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CountryRepository : JpaRepository<Country, String> {
    fun findByName(country: String): Optional<Country>
}