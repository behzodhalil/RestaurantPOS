// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    dependencies {
        gradle()
    }
}

plugins {
    id ("com.android.application") version (Versions.applicationVersion) apply (false)
    id ("com.android.library") version (Versions.libraryVersion) apply (false)
    id ("org.jetbrains.kotlin.android") version (Versions.kotlinVersion) apply (false)
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}