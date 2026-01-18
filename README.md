# AirQuality **Backend**

AirQuality Backend es una robusta **API** desarrollada en **Kotlin** y **Spring Boot 3** diseñada para actuar como el núcleo de procesamiento de datos de la aplicación móvil **AirQuality Android**. Su objetivo principal es facilitar el acceso jerárquico a información geográfica y proporcionar métricas precisas de contaminación y clima en tiempo real.

## Stack Tecnológico

- Lenguaje: `Kotlin 2.2.21`
- Framework: `Spring Boot 3.2.2 (WebFlux para alta concurrencia)`
- JDK: `21`
- Base de Datos: `PostgreSQL`
- Documentación: `SpringDoc OpenAPI 2.3.0`
- Cliente HTTP: `OpenFeign 4.1.0 (para consumo de IQAir)`

## Estructura del Proyecto

```
com.example.airqualityb/
├── client/                     # Interfaces de Feign para peticiones externas
├── config/                     # Configuración de Feign
├── controller/                 # Definición de Endpoints REST
├── dto/                        # Objetos de transferencia de datos (JSON)
├── entity/                     # Mapeo de tablas de base de datos (JPA)
├── repository/                 # Acceso a persistencia (City, State, Country)
├── service/                    # Lógica de negocio y procesamiento
└── AirQualityBApplication.kt   # Punto de entrada
```

## Configuración y Variables de Entorno

La API requiere la configuración de variables de entorno para la conexión a la base de datos y la autenticación con el servicio de IQAir:

- `IQAIR_API_KEY`: Tu clave privada obtenida en el dashboard de IQAir.
- `DB_URL`: jdbc:postgresql://localhost:5432/airquality
- `DB_USER`: Usuario de PostgreSQL (Default: admin).
- `DB_PASSWORD`: Contraseña de PostgreSQL (Default: admin).

## Documentación Interactiva (Swagger)

Para una experiencia de desarrollo fluida, la API integra Swagger UI. Esto permite probar cada endpoint en tiempo real, visualizar los esquemas de respuesta y entender los parámetros sin necesidad de herramientas externas como Postman.

Acceso: <ins>http://localhost:8080/swagger-ui.html</ins>
