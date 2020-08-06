rootProject.name = "my-boot-gradle"
include("mod-common")
include("mod-app")

pluginManagement {
    val verSpring: String by settings
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        maven {
            name = "gradle"
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    plugins {
        java
        `maven-publish`
        id("org.springframework.boot") version verSpring
        id("io.spring.dependency-management") version "1.0.6.RELEASE"
        id("io.freefair.lombok") version "5.1.0"
    }
}