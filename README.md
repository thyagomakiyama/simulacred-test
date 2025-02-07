# Simulacred

## Description
Simulacred is a simple code assessment test project.

## Dependencies
- Gradle 8.12
- Java 21

## How to Run

### Without Docker
```sh
chmod +x build.sh
./build.sh
./gradlew :api:bootRun
```

### Using Docker
```sh
docker-compose up --build -d
```

## Lint
This project uses ktlint for Kotlin code formatting. To run the linter, use:

```sh
./gradlew ktlintCheck
```

If you want to format source, run:

```sh
./gradlew ktlintFormat
```

## Tests
This project uses Kotest for unit testing. To run tests, use:

```sh
./gradlew test #all tests in project
./gradlew :core:test #only core test
./gradlew :api:test #only api test
```

## Project Structure
```
simulacred/
├── core/        # Core module (business logic)
│   ├── src/
│   ├── build.gradle.kts
├── api/         # API module (Spring WebFlux)
│   ├── src/
│   ├── build.gradle.kts
├── build.sh     
├── settings.gradle.kts
├── Dockerfile   
├── docker-compose.yml 
```

## API Documentation

The API documentation is available through Swagger. You can access it by navigating to:

📌 [Swagger UI](https://locahost:8080/api-doc)

This interface allows you to explore available endpoints, view request and response structures, and test API calls interactively. Make sure the server is running before accessing the documentation.