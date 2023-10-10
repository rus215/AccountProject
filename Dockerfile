FROM bellsoft/liberica-openjdk-alpine:11.0.19-7 AS builder
WORKDIR /java_build

ADD ./src src/
ADD ./gradle gradle/
ADD ./build.gradle.kts build.gradle.kts
ADD ./gradlew gradlew
ADD ./settings.gradle.kts settings.gradle.kts

RUN ./gradlew bootJar

FROM bellsoft/liberica-openjre-alpine:11.0.19-7
WORKDIR /web-app

COPY --from=builder java_build/build/libs/AccountProject-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]