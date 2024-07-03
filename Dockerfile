#Этап сборки
FROM maven:3.9.5-eclipse-temurin-21-alpine as build
WORKDIR /app

COPY target/pizzeria-0.0.1-SNAPSHOT.jar /app/pizzeria-0.0.1-SNAPSHOT.jar
COPY .env /app/.env

RUN java -Djarmode=layertools -jar pizzeria-0.0.1-SNAPSHOT.jar extract


#Этап выполнения
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

COPY --from=build /app/dependencies/ ./
COPY --from=build /app/spring-boot-loader/ ./
COPY --from=build /app/snapshot-dependencies/ ./
COPY --from=build /app/application/ ./
COPY --from=build /app/.env ./.env

ENTRYPOINT ["java", "-cp", ".:./*", "org.springframework.boot.loader.launch.JarLauncher"]
