plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk  = Configs.compileSdkVersion

    defaultConfig {
        applicationId = Configs.applicationIdName
        minSdk = Configs.minSdkVersion
        targetSdk  = Configs.targetSdkVersion
        versionCode = Configs.versionCodeVersion
        versionName  = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility  = JavaVersion.VERSION_1_8
        targetCompatibility  = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ("1.8")
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    core()
    appCompat()
    materialDesign()
    constraintLayout()
    junit()
    espresso()
    navigation()
    room()
    hilt()
    coroutine()
    workManager()
    viewPager()
    lifecycle()
    ktx()
    timber()
    logger()
}