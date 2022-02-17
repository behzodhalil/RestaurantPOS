import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.gradle() {
    classpath(Dependencies.gradleHilt)
    classpath(Dependencies.gradleNavigation)
}
fun DependencyHandler.core() {
    implementation(Dependencies.core)
}

fun DependencyHandler.appCompat() {
    implementation(Dependencies.appCompat)
}

fun DependencyHandler.materialDesign() {
    implementation(Dependencies.materialDesign)
}

fun DependencyHandler.constraintLayout() {
    implementation(Dependencies.constraintLayout)
}

fun DependencyHandler.junit() {
    testImplementation(Dependencies.jUnit)
    androidTestImplementation(Dependencies.jUnitTest)
}

fun DependencyHandler.espresso() {
    androidTestImplementation(Dependencies.espresso)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUI)
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    kapt (Dependencies.roomKapt)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltKapt)
}

fun DependencyHandler.coroutine() {
    implementation(Dependencies.coroutine)
}

fun DependencyHandler.workManager() {
    implementation(Dependencies.workManager)
}

fun DependencyHandler.viewPager() {
    implementation(Dependencies.viewPager)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.lifecycleLiveData)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleViewModel)
}

fun DependencyHandler.ktx() {
    implementation(Dependencies.ktxActivity)
    implementation(Dependencies.ktxFragment)
    implementation(Dependencies.ktxAppCompat)
}

fun DependencyHandler.timber() {
    implementation(Dependencies.timber)
}

fun DependencyHandler.logger() {
    implementation(Dependencies.logger)
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