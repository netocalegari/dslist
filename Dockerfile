FROM maven:3.9.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/dslist-0.0.1-SNAPSHOT.jar dslist.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dslist.jar"]
