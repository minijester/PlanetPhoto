plugins {
    id(Plugins.ANDROID_APPLICATION_PLUGIN)
    id(Plugins.KOTLIN_ANDROID_PLUGIN)
    id(Plugins.KOTLIN_KAPT_PLUGIN)
    id(Plugins.KOTLIN_PARCELIZE)
    id(Plugins.NAV_SAFE_ARGS_PLUGIN)
    id(Plugins.DAGGER_HILT_PLUGIN)
}

android {
    compileSdk = Config.compileSdkVersion
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        applicationId = "com.miharu.planetphoto"
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.ANDROIDX_CORE_KTX)
    implementation(Dependencies.ANDROIDX_APP_COMPAT)
    implementation(Dependencies.ANDROIDX_MATERIAL)
    implementation(Dependencies.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(Dependencies.ANDROIDX_NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.ANDROIDX_NAVIGATION_UI_KTX)
    implementation(Dependencies.HILT_ANDROID)
    implementation(Dependencies.HILT_VIEW_MODEL)
    implementation(Dependencies.HILT_COMMON)
    implementation(Dependencies.KOTLIN)
    implementation(Dependencies.SPLASH_SCREEN)

    kapt(Dependencies.HILT_ANDROID_COMPILER)
    kapt(Dependencies.HILT_COMPILER)

    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.BYTE_BUDDY_ANDROID)
    testImplementation(Dependencies.Test.BYTE_BUDDY_AGENT)
    testImplementation(Dependencies.Test.MOCKITO_CORE)
    testImplementation(Dependencies.Test.MOCKITO_INLINE)
    testImplementation(Dependencies.Test.MOCKK)
    testImplementation(Dependencies.Test.MOCKK_ANDROID){
        exclude ( "io.mockk", "mockk-agent-jvm")
    }
    testImplementation(Dependencies.Test.GOOGLE_TRUTH)
    testImplementation(Dependencies.Test.COROUTINES_TEST)
    testImplementation(Dependencies.Test.CORE_TESTING)
    testImplementation(Dependencies.Test.TEST_RULE)
    testImplementation(Dependencies.Test.TEST_RUNNER)
    testImplementation(Dependencies.Test.ROBOLECTRIC)
    testImplementation(Dependencies.Test.TESTING_HILT_ANDROID_TESTING) {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }
    kaptTest(Dependencies.Test.TESTING_HILT_ANDROID_COMPILER) {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }
    androidTestImplementation(Dependencies.Test.ANDROIDX_ESPRESSO)
    androidTestImplementation(Dependencies.Test.ANDROIDX_JUNIT)
    androidTestImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.GOOGLE_TRUTH)
    androidTestImplementation(Dependencies.Test.COROUTINES_TEST)
    androidTestImplementation(Dependencies.Test.CORE_TESTING)
    androidTestImplementation(Dependencies.Test.TEST_RULE)
    androidTestImplementation(Dependencies.Test.TEST_RUNNER)
    androidTestImplementation(Dependencies.Test.TESTING_HILT_ANDROID_TESTING) {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }
    kaptAndroidTest(Dependencies.Test.TESTING_HILT_ANDROID_COMPILER) {
        exclude("org.jetbrains.kotlinx", "kotlinx-coroutines-debug")
    }
}