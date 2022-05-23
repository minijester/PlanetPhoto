object Plugins {
    const val CLASSPATH_GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE_VERSION}"
    const val CLASSPATH_NAVIGATION_ARGS =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.ANDROID_NAVIGATION_VERSION}"
    const val CLASSPATH_HILT =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.ANDROID_HILT_VERSION}"

    const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
    const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
    const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
    const val KOTLIN_PARCELIZE = "kotlin-parcelize"
    const val KOTLIN_KAPT_PLUGIN = "kotlin-kapt"
    const val NAV_SAFE_ARGS_PLUGIN = "androidx.navigation.safeargs.kotlin"
    const val DAGGER_HILT_PLUGIN = "dagger.hilt.android.plugin"

}