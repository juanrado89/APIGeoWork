# Usa la imagen base de OpenJDK 17
FROM openjdk:17-jdk-alpine

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR de tu aplicación a la imagen
COPY target/APIGeoWork.jar app.jar

# Expone el puerto en el que se ejecutará la aplicación (usualmente 8080 para Spring Boot)
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
