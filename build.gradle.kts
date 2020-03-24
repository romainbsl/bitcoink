plugins {
    kotlin("multiplatform") version "1.3.71"
    kotlin("plugin.serialization") version "1.3.71"
    `maven-publish`
}

group = "fr.acinq"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */

    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:0.20.0")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.bouncycastle:bcprov-jdk15on:1.64")
                implementation("fr.acinq.bitcoin:secp256k1-jni:1.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.8")
                implementation("com.google.guava:guava:28.2-jre")
            }
        }
    }
}