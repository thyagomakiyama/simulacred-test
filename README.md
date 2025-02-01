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

## Project Structure
```
simulacred/
├── core/        # Core module (business logic)
│   ├── src/
│   ├── build.gradle.kts
├── api/         # API module (Spring WebFlux)
│   ├── src/
│   ├── build.gradle.kts
├── build.sh     # Build script
├── settings.gradle.kts
├── Dockerfile   # Docker configuration
├── docker-compose.yml  # Docker Compose configuration
```
