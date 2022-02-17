object Dependencies {

    // Gradle
    const val gradleHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val gradleNavigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
    // Core
    const val core = "androidx.core:core-ktx:${Versions.coreVersion}"

    // AppCompat
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    // Material Design
     const val materialDesign = "com.google.android.material:material:${Versions.materialVersion}"

    // ConstraintLayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"

    // Test
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val jUnitTest = "androidx.test.ext:junit:${Versions.jUnitTestVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

    // Jetpack Navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx=${Versions.navigationVersion}"
    const val navigationUI= "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.roomVersion}"

    // Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"

    // Coroutine
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    // WorkManager
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workVersion}"

    // ViewPager2
    const val viewPager = "androidx.viewpager2:viewpager2:${Versions.viewPagerVersion}"

    // Lifecycle
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"

    // Activity & Fragment KTX
    const val ktxFragment = "androidx.fragment:fragment-ktx:${Versions.ktxVersion}"
    const val ktxActivity = "androidx.activity:activity-ktx:${Versions.ktxActivityVersion}"
    const val ktxAppCompat = "androidx.appcompat:appcompat:${Versions.ktxVersion}"

    // Timber & Logger
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"
    const val logger = "com.orhanobut:logger:${Versions.loggerVersion}"
}