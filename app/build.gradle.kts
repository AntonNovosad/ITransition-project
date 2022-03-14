import ConfigData.compileSdk

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigData.compileSdk

    defaultConfig {
        applicationId = "com.example.itransition_project"
        minSdk = ConfigData.minSdk
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    val nav_version = "2.4.1"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    implementation(project(":ui"))
    implementation(Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.extJUnit)
    androidTestImplementation(Dependencies.espresso)
}