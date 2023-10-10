plugins {
    java
    id("org.springframework.boot") version "2.5.15"
}

group = "com.example"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
springBoot {
    mainClass = "com.example.account.project.AccountProjectApplication"
}

repositories {
    mavenCentral()
    mavenLocal()
}

val springBootVersion by extra("2.5.15")
val mapstructVersion by extra("1.5.5.Final")
val lombokVersion by extra("1.18.30")
val lombokMapstructBindingVersion by extra("0.2.0")

dependencies {
    // Spring
    implementation(platform("org.springframework.boot:spring-boot-starter-parent:${springBootVersion}"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.kafka:spring-kafka")

    //Database
    implementation("org.liquibase:liquibase-core")
    implementation("org.postgresql:postgresql")
    //Mapper
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    //lombok
    implementation("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:${lombokMapstructBindingVersion}")
    //Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.jar {
    enabled = false
}

tasks.withType<Test> {
    useJUnitPlatform()
}
