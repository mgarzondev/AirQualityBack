package com.example.airqualityb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AirQualityBApplication

fun main(args: Array<String>) {
    runApplication<AirQualityBApplication>(*args)
}
