# Використовуємо образ з Java 21 (як вказано у твоєму pom.xml)
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Копіюємо JAR-файл із залежностями, який створить Maven
COPY target/*-jar-with-dependencies.jar app.jar

# Відкриваємо порт сервера
EXPOSE 7150

# Запускаємо сервер
ENTRYPOINT ["java", "-jar", "app.jar"]