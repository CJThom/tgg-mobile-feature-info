buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Dependencies.Plugins.ClassPaths.buildTools)
        classpath(Dependencies.Plugins.ClassPaths.kotlinGradlePlugin)
        classpath(Dependencies.Plugins.ClassPaths.hiltGradlePlugin)
    }

}

allprojects {

    repositories {
        google()
        mavenCentral()

        maven {
            url = uri("https://jitpack.io")
            credentials(HttpHeaderCredentials::class) {
                name = "authToken"
                value = "jp_2jo1qjm1jmh2dpp77f8t042rcf"
            }
        }
    }

}



tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
