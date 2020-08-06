plugins {
    id("io.spring.dependency-management")
    id("org.springframework.boot") apply false
    id("io.freefair.lombok") apply false
}

subprojects {
    group = "org.st"
    version = "1.0-SNAPSHOT"

    val verSpring: String by project

    apply {
        plugin("java")
        plugin("io.spring.dependency-management")
    }

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        maven {
            name = "gradle"
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
        dependencies {
            dependency("junit:junit:4.12")
        }
    }

    tasks {
        "javadoc"(Javadoc::class) {
            options.encoding = "UTF-8"
        }
        "compileJava"(JavaCompile::class) {
            options.encoding = "UTF-8"
            sourceCompatibility = "1.8"
        }
        "compileTestJava"(JavaCompile::class) {
            options.encoding = "UTF-8"
            sourceCompatibility = "1.8"
        }
    }
}



tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "6.5.1"
    }
}
