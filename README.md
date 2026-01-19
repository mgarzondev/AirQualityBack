# AirQuality Backend

AirQuality Backend es una robusta **API** desarrollada en **Kotlin** y **Spring Boot 3** diseñada para actuar como el núcleo de procesamiento de datos de la aplicación móvil **AirQuality Android**. Su objetivo principal es facilitar el acceso jerárquico a información geográfica y proporcionar métricas precisas de contaminación y clima en tiempo real.

## Instrucciones para usar AirQuality Backend

1. Copiar repositorio de git:

      ```git clone https://github.com/mgarzondev/AirQualityBack.git```

2. Configurar variables de entorno: 

      [Configuración y Variables de Entorno](#configuración-y-variables-de-entorno)

3. Configuración de la base de datos _(Docker desde la terminal)_ :

   El backend está configurado para conectarse a una base de datos llamada ```airquality```. Debes crearla manualmente antes de iniciar la aplicación.

   Para levantar el motor _(Postgres)_ de base de datos, abre tu terminal y ejecuta el siguiente comando. Este comando configurará automáticamente el contenedor con los accesos que el backend necesita:

     ```docker run --name postgres -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=admin -e POSTGRES_DB=airquality -p 5432:5432 -d postgres```

     ### ¿Qué hace este comando?

        --name postgres: Nombra al contenedor como "postgres".
     
        -e POSTGRES_USER=admin: Crea el usuario admin.
     
        -e POSTGRES_PASSWORD=admin: Define la contraseña como admin.
     
        -e POSTGRES_DB=airquality: Crea la base de datos airquality automáticamente.

        -p 5432:5432: Abre el puerto para que tu backend y cliente db puedan entrar.
     
        -d postgres: Descarga la imagen oficial y corre todo en segundo plano.

  4. Sincronizar dependecias ```build.gradle.kts```
     
  5. Correr ```AirQualityBApplication.kt```
     
   
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

      
   
