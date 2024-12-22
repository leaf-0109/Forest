package com.leaf.convention

import com.android.build.api.dsl.ApplicationExtension
import com.leaf.convention.extention.ExtensionType
import com.leaf.convention.extention.configureBuildTypes
import com.leaf.convention.extention.configureKotlinAndroid
import com.leaf.convention.extention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = "com.leaf.Forest"
                    versionName = "1.0.0"
                    versionCode = 1
                    compileSdk = 35
                    targetSdk = 34
                    minSdk = 24
                }

                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.APPLICATION
                )
            }
        }
    }
}