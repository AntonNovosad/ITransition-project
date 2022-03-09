import ConfigData.compileSdk

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
}

android {
    compileSdkVersion(ConfigData.compileSdk)

  defaultConfig {
    applicationId = "com.example.itransition_project"
    minSdkVersion(ConfigData.minSdk)
    targetSdkVersion(ConfigData.targetSdk)
    versionCode = ConfigData.versionCode
    versionName = ConfigData.versionName


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
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {

  implementation(Dependencies.coreKtx)
  implementation(Dependencies.appCompat)
  implementation(Dependencies.material)
  implementation(Dependencies.constraintLayout)
  testImplementation(Dependencies.jUnit)
  androidTestImplementation(Dependencies.extJUnit)
  androidTestImplementation(Dependencies.espresso)
}