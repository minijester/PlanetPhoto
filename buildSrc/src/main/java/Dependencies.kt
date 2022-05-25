object Dependencies {
    // KOTLIN
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE_VERSION}"

    // Android X
    const val ANDROIDX_APP_COMPAT =
        "androidx.appcompat:appcompat:${Versions.ANDROID_APPCOMPAT_VERSION}"
    const val ANDROIDX_LIVE_DATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ANDROID_LIFECYCLE_VERSION}"
    const val ANDROIDX_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ANDROID_LIFECYCLE_VERSION}"
    const val ANDROIDX_LIFE_CYCLE =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.ANDROID_LIFECYCLE_VERSION}"
    const val ANDROIDX_CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.ANDROID_CONSTRAINTLAYOUT_VERSION}"
    const val ANDROIDX_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROID_CORE_KTX_VERSION}"
    const val ANDROIDX_MATERIAL =
        "com.google.android.material:material:${Versions.ANDROID_MATERIAL_VERSION}"
    const val ANDROIDX_NAVIGATION_UI_KTX =
        "androidx.navigation:navigation-ui-ktx:${Versions.ANDROID_NAVIGATION_VERSION}"
    const val ANDROIDX_NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${Versions.ANDROID_NAVIGATION_VERSION}"
    const val SPLASH_SCREEN = "androidx.core:core-splashscreen:${Versions.SPLASH_SCREEN_VERSION}"

    //hilt
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.ANDROID_HILT_VERSION}"
    const val HILT_VIEW_MODEL =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.ANDROIDX_HILT_VERSION}"
    const val HILT_COMMON = "androidx.hilt:hilt-common:${Versions.ANDROIDX_HILT_VERSION}"
    const val HILT_ANDROID_COMPILER =
        "com.google.dagger:hilt-compiler:${Versions.ANDROID_HILT_VERSION}"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${Versions.ANDROIDX_HILT_VERSION}"

    //retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"

    //room
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val ROOM_COMPILER = "androidx.room:room-compiler${Versions.ROOM_VERSION}"

    //gson
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"

    //Glide
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"

    // Paging
    const val PAGING = "androidx.paging:paging-runtime:${Versions.PAGING_VERSION}"

    object Test {
        const val JUNIT = "junit:junit:${Versions.JUNIT_VERSION}"
        const val ANDROIDX_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT_VERSION}"
        const val ANDROIDX_ESPRESSO =
            "androidx.test.espresso:espresso-core:${Versions.ANDROID_ESPRESSO_VERSION}"
        const val GOOGLE_TRUTH = "com.google.truth:truth:${Versions.GOOGLE_TRUTH_VERSION}"
        const val COROUTINES_TEST =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINE_TEST_VERSION}"
        const val CORE_TESTING = "androidx.arch.core:core-testing:${Versions.CORE_TESTING_VERSION}"
        const val TEST_CORE = "androidx.test:core-ktx:${Versions.ANDROIDX_TEST_VERSION}"
        const val TESTING_HILT_ANDROID_TESTING =
            "com.google.dagger:hilt-android-testing:${Versions.ANDROID_HILT_VERSION}"
        const val TESTING_HILT_ANDROID_COMPILER =
            "com.google.dagger:hilt-android-compiler:${Versions.ANDROID_HILT_VERSION}"
        const val TEST_RULE = "androidx.test:rules:${Versions.ANDROIDX_TEST_VERSION}"
        const val TEST_RUNNER = "androidx.test:runner:${Versions.ANDROIDX_TEST_VERSION}"
        const val ROBOLECTRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC_VERSION}"

        const val BYTE_BUDDY_ANDROID = "net.bytebuddy:byte-buddy-android:${Versions.BYTE_BUDDY}"
        const val BYTE_BUDDY_AGENT = "net.bytebuddy:byte-buddy-agent:${Versions.BYTE_BUDDY}"
        const val MOCKITO_CORE = "org.mockito:mockito-core:${Versions.MOCKITO}"
        const val MOCKITO_INLINE = "org.mockito:mockito-inline:${Versions.MOCKITO}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
    }
}