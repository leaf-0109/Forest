plugins {
    alias(libs.plugins.forest.android.application.compose)
}

android {
    namespace = "com.leaf.forest"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.activity.compose)
}