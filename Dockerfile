# Шаг 1: Используем официальный образ OpenJDK 17 как базовый
FROM eclipse-temurin:17-jdk-jammy

# Шаг 2: Указываем рабочую директорию
WORKDIR /app

# Шаг 3: Копируем файл сборки JAR в контейнер
COPY target/orm-demo-1.0-SNAPSHOT.jar app.jar

# Шаг 4: Указываем команду запуска
ENTRYPOINT ["java", "-jar", "app.jar"]