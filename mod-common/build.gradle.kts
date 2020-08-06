plugins {
    java
    `maven-publish`
    id("io.freefair.lombok")
}

dependencies {
    testImplementation("junit:junit")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

