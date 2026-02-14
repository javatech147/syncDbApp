plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.devtools.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.syncdbapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.syncdbapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // viewmodel
    implementation(libs.lifecycle.viewmodel.kts)

    // work-manager
    implementation(libs.work.runtime.ktx)

    // room-db
    implementation(libs.room.runtime)
    // implementation(libs.androidx.hilt.common)
    // implementation(libs.androidx.hilt.work)
    ksp(libs.room.compilter)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.work)
    ksp(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}