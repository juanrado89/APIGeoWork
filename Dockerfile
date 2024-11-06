# Usa una imagen de Maven para construir el proyecto
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copia el código fuente al contenedor
COPY . .

# Construye el JAR
RUN mvn clean package -DskipTests

# Usa una imagen más ligera de OpenJDK para ejecutar el JAR
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copia el JAR desde la imagen de construcción
COPY --from=build /app/target/APIGeoWork-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
