FROM eclipse-temurin:21-jre-alpine

WORKDIR /app


COPY target/*-jar-with-dependencies.jar app.jar


EXPOSE 7150

ENTRYPOINT ["java", "-jar", "app.jar"]