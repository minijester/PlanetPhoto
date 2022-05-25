// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.CLASSPATH_GRADLE)
        classpath(kotlin("gradle-plugin", version = Versions.KOTLIN_VERSION))
        classpath(Plugins.CLASSPATH_NAVIGATION_ARGS)
        classpath(Plugins.CLASSPATH_HILT)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}