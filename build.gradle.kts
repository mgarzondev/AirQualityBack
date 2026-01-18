plugins {
    kotlin("jvm") version "2.2.21"
    kotlin("plugin.spring") version "2.2.21"
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "AirQualityB"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // Permite que la aplicación sea un servidor web capaz de manejar muchas peticiones simultáneas
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // DOCUMENTACIÓN (Swagger específico para WebFlux)
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.3.0")

    // Librerias necesarias para que Spring Boot pueda analizar el código
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    //Permite usar coroutines fun suspend
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // Convierte el JSON en objetos kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    // Para la Base de Datos
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.postgresql:postgresql")

    // Para las peticiones a IQAir
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.0")

}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
