FROM maven:3.9.5 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean package -DskipTests
FROM openjdk:17
COPY --from=build /app/target/springboot-mysql-docker.jar springboot-mysql-docker.jar
ENTRYPOINT ["java", "-jar", "/springboot-mysql-docker.jar"]