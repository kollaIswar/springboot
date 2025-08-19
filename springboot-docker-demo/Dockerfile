# Step 1: Use an official JDK to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run the jar in a lightweight JRE container
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/springboot-docker-demo.jar springboot-docker-demo.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot-docker-demo.jar"]
