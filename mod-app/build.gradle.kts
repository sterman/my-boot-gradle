plugins {
    java
    `maven-publish`
    id("org.springframework.boot")
    id("io.freefair.lombok")
}

dependencies {
    implementation(project(":mod-common"))
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
    }
    compileOnly("org.springframework.boot:spring-boot-starter-jetty")
    testImplementation("junit:junit")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    "bootJar"(org.springframework.boot.gradle.tasks.bundling.BootJar::class) {
        mainClassName = "org.st.ModApp"
    }
}