import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.android.tools.common)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "forest.android.application"
            implementationClass = "com.leaf.convention.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "forest.android.application.compose"
            implementationClass = "com.leaf.convention.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "forest.android.library"
            implementationClass = "com.leaf.convention.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "forest.android.library.compose"
            implementationClass = "com.leaf.convention.AndroidLibraryComposeConventionPlugin"
        }
        register("androidRoom") {
            id = "forest.android.room"
            implementationClass = "com.leaf.convention.AndroidRoomConventionPlugin"
        }
    }
}