package com.example.airqualityb.config

import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter

@Configuration
class FeignConfig {

    @Bean
    fun messageConverters(): HttpMessageConverters {
        val jacksonConverter = MappingJackson2HttpMessageConverter()
        return HttpMessageConverters(jacksonConverter)
    }
}