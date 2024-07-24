plugins {
    id("maven-publish")
}

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }

    configurations.all {
        resolutionStrategy {
            failOnVersionConflict()
            preferProjectModules()
        }
    }
}


publishing {
    publications {
        create<MavenPublication>("gpr") {
            from(components["release"])
            groupId = "com.yeduRaghav"
            artifactId = "sdk"
            version = "1.0.2"

            artifact("$buildDir/outputs/aar/sdk-release.aar")
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/yeduRaghav/testsdk1")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GPR_USER")
                password = project.findProperty("gpr.token") as String? ?: System.getenv("GPR_TOKEN")
            }
        }
    }
}


