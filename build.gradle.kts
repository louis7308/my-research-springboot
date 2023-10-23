import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    // DB
    implementation ("org.redisson:redisson-spring-boot-starter:3.18.0")

    //redis
    implementation ("org.redisson:redisson-spring-boot-starter:3.18.0")

    // websocket
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    runtimeOnly("com.mysql:mysql-connector-j")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // JUnit5
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.50")
    // AssertJ
    testImplementation("org.assertj:assertj-core:3.13.2")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

tasks {
    test {
        useJUnitPlatform()
    }
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
    withType<Test> {
        useJUnitPlatform()
    }
}