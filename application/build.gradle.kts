plugins {
    id("io.spring.dependency-management")
    id("org.springframework.boot") version "2.4.0"
}
dependencies {
    implementation(project(":domain"))
    implementation("org.springframework:spring-context")
}

val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true
