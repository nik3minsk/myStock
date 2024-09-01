import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig

// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    alias(libs.plugins.android.application) apply false
//}
//
//dependencies {
//    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
//    implementation("com.google.zxing:core:3.3.0")
//}


//plugins {
//    alias(libs.plugins.android.application) apply false
//}
//repositories {
//    mavenCentral()
//}
//maven {
//    url 'http://dl.bintray.com/journeyapps/maven'
//}


//android {
//    compileSdkVersion 30
//    defaultConfig {
//        applicationId "com.example.myapp"
//        minSdkVersion 16
//        targetSdkVersion 30
//        versionCode 1
//        versionName "1.0"
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
//        }
//    }
//}

//dependencies {
//    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
//    implementation("com.google.zxing:core:3.3.0")
//}

//dependencies {
//    implementation 'com.journeyapps:zxing-android-embedded:2.3.0@aar'
//    implementation 'com.journeyapps:zxing-android-legacy:2.3.0@aar'
//    implementation 'com.journeyapps:zxing-android-integration:2.3.0@aar'
//    implementation 'com.google.zxing:core:3.2.0'
//}


plugins {
//    id("com.android.application")
//    id("org.jetbrains.kotlin.android")
    alias(libs.plugins.android.application) apply false
}

