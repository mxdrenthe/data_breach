FROM maven:3.9.5-eclipse-temurin-17 AS build
WORKDIR /usr/app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn --show-version --errors package

FROM gcr.io/distroless/java17-debian11:nonroot
WORKDIR /usr/app
COPY --from=build /usr/app/target/*.jar /usr/app/ctf-data-breach.jar

EXPOSE 8380
ENTRYPOINT ["java", "-jar", "/usr/app/ctf-data-breach.jar"]
