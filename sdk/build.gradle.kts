plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "org.thvc.sdk"
    compileSdk = 33

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(project(":domain"))
    implementation(project(":web"))
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.core:core-ktx:1.10.1")
}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("gpr") {
                from(components["release"])
                groupId = "com.yeduRaghav"
                artifactId = "sdk"
                version = "1.0.3"

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
}


tasks.register("listComponents") {
    doLast {
        components.forEach { component ->
            println("Component: ${component.name}")
        }
    }
}