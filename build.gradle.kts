plugins {
    id("java")
}

group = "com.deichor"
version = "1.0-SNAPSHOT"

repositories {
    maven {
        url=uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url=uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }
    mavenCentral()
}

dependencies {
    compileOnly("me.clip:placeholderapi:2.11.6")
    compileOnly("dev.folia:folia-api:1.20.6-R0.1-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}