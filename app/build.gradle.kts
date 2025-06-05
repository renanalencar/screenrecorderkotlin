plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

val versionMajor = 0
val versionMinor = 3
val versionPatch = 0
val isSnapshotVersion = false

val versionNameGradle: String
    get() {
        val versionString = "$versionMajor.$versionMinor.$versionPatch"

        if (isSnapshotVersion) {
            return "$versionString-SNAPSHOT"
        }
        return versionString
    }

val versionCodeGradle: Int
    get() {
        return versionMajor * 10000 + versionMinor * 100 + versionPatch
    }

android {
    namespace = "br.com.renanalencar.screenrecorder"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.renanalencar.screenrecorder"
        minSdk = 34
        targetSdk = 35
        versionCode = versionCodeGradle
        versionName = versionNameGradle

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
