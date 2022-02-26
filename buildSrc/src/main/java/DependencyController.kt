import org.gradle.api.artifacts.dsl.DependencyHandler

// Implementation function of Gradle
fun DependencyHandler.gradle() {
    classpath(Dependencies.gradleHilt)
    classpath(Dependencies.gradleNavigation)
}

// Implementation function of Core
fun DependencyHandler.core() {
    implementation(Dependencies.core)
}

// Implementation function of AppCompat
fun DependencyHandler.appCompat() {
    implementation(Dependencies.appCompat)
}

// Implementation function of MaterialDesign
fun DependencyHandler.materialDesign() {
    implementation(Dependencies.materialDesign)
}

// Implementation function of ConstraintLayout
fun DependencyHandler.constraintLayout() {
    implementation(Dependencies.constraintLayout)
}

// Implementation function of Test
fun DependencyHandler.test() {
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.jUnitTest)
    androidTestImplementation(Dependencies.espresso)
}

// Implementation function of Navigation
fun DependencyHandler.navigation() {
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}

// Implementation function of Room
fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt (Dependencies.roomKapt)
}

// Implementation function of Hilt
fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltKapt)
}

// Implementation function of Coroutine
fun DependencyHandler.coroutine() {
    implementation(Dependencies.coroutine)
}

// Implementation function of WorkManager
fun DependencyHandler.workManager() {
    implementation(Dependencies.workManager)
}

// Implementation function of ViewPager2
fun DependencyHandler.viewPager() {
    implementation(Dependencies.viewPager)
}

// Implementation function of Lifecycle
fun DependencyHandler.lifecycle() {
    implementation(Dependencies.lifecycleLiveData)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)
}

// Implementation function of KTX
fun DependencyHandler.ktx() {
    implementation(Dependencies.ktxActivity)
    implementation(Dependencies.ktxFragment)
    implementation(Dependencies.ktxAppCompat)
}

// Implementation function of Timber
fun DependencyHandler.timber() {
    implementation(Dependencies.timber)
}

// Implementation function of Logger
fun DependencyHandler.logger() {
    implementation(Dependencies.logger)
}

// Implementation function of Ini4j
fun DependencyHandler.ini4j() {
    implementation(Dependencies.ini4j)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation",depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt",depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation",depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation",depName)
}

private fun DependencyHandler.classpath(depName: String) {
    add("classpath", depName)
}