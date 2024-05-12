plugins {
    id ("com.android.application")
    id ("com.google.gms.google-services")
}

android {
    namespace = "ali.abdou.arauth"
    compileSdk = 34

    defaultConfig {
        applicationId = "ali.abdou.arauth"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.4.0") // Replace with the latest version
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.google.firebase:firebase-auth:22.3.0")
    implementation("com.android.volley:volley:1.2.1")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.github.TutorialsAndroid:GButton:v1.0.19")
    implementation ("com.google.android.gms:play-services-auth:20.4.0")
    implementation ("androidx.credentials:credentials:1.3.0-alpha01")
    implementation ("com.google.android.material:material:<latest_version>")
    implementation ("com.google.firebase:firebase-firestore:24.0.0") // Replace with the latest version
    implementation ("com.squareup.retrofit2:retrofit:2.3.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.1.0")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.3")

    // Uncomment the following dependencies if you want to include Navigation components
    // implementation 'androidx.navigation:navigation-fragment:2.4.0' // Replace with the latest version
    // implementation 'androidx.navigation:navigation-ui:2.4.0' // Replace with the latest version
}

// Specify the versions of the plugins separately
buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:8.4.0")
        classpath ("com.google.gms:google-services:4.3.10")
    }
}
