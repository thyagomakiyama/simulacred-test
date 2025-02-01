FROM gradle:8.12-jdk21 AS builder

WORKDIR /app

COPY core/build.gradle.kts ./core/
COPY api/build.gradle.kts ./api/
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY core/src ./core/src
COPY api/src ./api/src

RUN gradle :core:clean :core:build
RUN gradle :api:clean :api:build

FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=builder /app/api/build/libs/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/api-0.0.1-SNAPSHOT.jar"]