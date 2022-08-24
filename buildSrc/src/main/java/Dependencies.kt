import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.kotlin.dsl.*
import java.util.ArrayList

object Dependencies {

    object Versions {

        val fileTree = mapOf("dir" to "libs", "include" to listOf("*.jar"))

        const val gradle = "7.2.2"
        val desugar = "1.1.6"
        val kotlin = "1.7.10"
        val ksp = "1.7.10-1.0.6"
        val kotlinx_datetime = "0.4.0"
        val kotlinx_serialization_json = "1.4.0-RC"

        val hilt = "2.43.2"
        val room = "2.4.0-alpha05"
        val dataStorePrefs = "1.0.0"
        val activity = "1.5.1"
        val coroutines = "1.6.4"
        val analytics = "18.0.1"
        val leakcanary = "2.9.1"
        val core = "1.8.0"
        val collection = "1.2.0"
        val threetenabp = "1.3.1"

        //  val appcompat = "1.4.1"
        val appcompat = "1.5.0"
        val timber = "5.0.1"
        val retrofit = "2.9.0"
        val work_runtime = "2.7.1"
        val hilt_androidx = "1.0.0"
        val stetho = "1.6.0"
        val retrofit2_kotlinx_serialization_converter = "0.8.0"
        val retrofit2_kotlin_coroutines_adapter = "0.9.2"
        val okhttp = "5.0.0-alpha.10"
        val ktor = "2.1.0"
        val logbook = "1.2.11"
        val paging = "3.1.1"
        val coil = "2.1.0"

        // Compose
        val compose = "1.2.1"
        val compose_compiler = "1.3.0"
        val accompanist = "0.25.1"
        val constraintlayout_compose = "1.0.1"
        val hilt_navigation_compose = "1.0.0"

        // XML
        val fragment = "1.5.2"
        val recyclerview = "1.2.1"
        val glide = "4.12.0"
        val coordinatorlayout = "1.2.0"
        val constraintlayout = "2.1.4"
        val viewpager2 = "1.0.0"
        val cardview = "1.0.0"
        val swiperefreshlayout = "1.2.0-alpha01"
        val lifecycle = "2.5.1"
        val navigation = "2.5.1"
        val material = "1.6.1"
        val java = JavaVersion.VERSION_11
        val jvm = "11"
    }

    object Modules {
        private val base = "com.github.TGG-Dev.tgg-mobile-"

        object Core {
            private val coreBase = "${base}core-pos:"

            fun common(version: String) = "${coreBase}common:${version}"
            fun data(version: String) = "${coreBase}data:${version}"
            fun domain(version: String) = "${coreBase}domain:${version}"
            fun presentation(version: String) = "${coreBase}presentation:${version}"
            fun compose(version: String) = "${coreBase}compose:${version}"
            fun xml(version: String) = "${coreBase}xml:${version}"

            fun domainLibraryList(version: String) = arrayListOf<String>().apply {
                add(common(version))
                add(domain(version))
            }

            fun dataLibraryList(version: String) = arrayListOf<String>().apply {
                addAll(domainLibraryList(version))
                add(data(version))
            }

            fun presentationLibraryList(version: String) = arrayListOf<String>().apply {
                addAll(domainLibraryList(version))
                add(presentation(version))
                add(compose(version))
            }

            fun xmlPresentationLibraryList(version: String) = arrayListOf<String>().apply {
                addAll(domainLibraryList(version))
                add(presentation(version))
                add(xml(version))
            }

//            val common = "${coreBase}common:${Versions.tggmobilecorepos}"
//            val compose = "${coreBase}compose:${Versions.tggmobilecorepos}"
//            val xml = "${coreBase}xml:${Versions.tggmobilecorepos}"
//            val data = "${coreBase}data:${Versions.tggmobilecorepos}"
//            val domain = "${coreBase}domain:${Versions.tggmobilecorepos}"
//            val presentation =
//                "${coreBase}presentation:${Versions.tggmobilecorepos}"
//


        }

        object Login {
            private val loginBase = "${base}feature-login:"
            fun data(version: String) = "${loginBase}data:${version}"
            fun domain(version: String) = "${loginBase}domain:${version}"
            fun presentation(version: String) = "${loginBase}presentation:${version}"
        }
    }

    object Plugins {

        object ClassPaths {
            val buildTools = "com.android.tools.build:gradle:${Versions.gradle}"
            val kotlinGradlePlugin =
                "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
            val kotlinSerialization =
                "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
            val safeArgsGradlePlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
            val hiltGradlePlugin =
                "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

        }

        val androidApplication = "com.android.application"
        val androidLibrary = "com.android.library"
        val kotlinAndroid = "android"
        val kotlinKapt = "kapt"
        val kotlinSerialization = "kotlinx-serialization"
        val hiltAndroid = "dagger.hilt.android.plugin"
        val ksp = "com.google.devtools.ksp"
        val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
        val mavenPublish = "maven-publish"

    }

    object Common {

        val desugarJdk = "com.android.tools:desugar_jdk_libs:${Versions.desugar}"

        val kotlinXCoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
        val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

        val kotlinDateTime =
            "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinx_datetime}"

        val analytics =
            "com.google.android.gms:play-services-analytics:${Versions.analytics}"

        val kotlinSerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization_json}"

        val androidCoreKtx = "androidx.core:core-ktx:${Versions.core}"

        val baseImplementationLibraryList: ArrayList<String> = arrayListOf<String>().apply {
            add(kotlinXCoroutinesCore)
            add(hiltAndroid)
            add(kotlinDateTime)
        }

        val baseKaptLibraryList: ArrayList<String> = arrayListOf<String>().apply {
            add(hiltAndroidCompiler)
        }
    }

    object Data {


        val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        val retrofitCoroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit2_kotlin_coroutines_adapter}"
        val retrofitKotlinSerializationConverter =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofit2_kotlinx_serialization_converter}"

        val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        val roomRuntime = "androidx.room:room-runtime:${Versions.room}"

        val dataStorePrefs = "androidx.datastore:datastore-preferences:${Versions.dataStorePrefs}"

        val facebookStetho = "com.facebook.stetho:stetho:${Versions.stetho}"
        val facebookStethoOkHttp3 =
            "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"

        val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        val okhttp3LoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"

        val kotlinXSerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization_json}"

        object Ktor {
            val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
            val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
            val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
            val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        }

        val logbackClassic = "ch.qos.logback:logback-classic:${Versions.logbook}"

    }

    object Presentation {

        val lifecycleLivedata =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        val lifecycleRunTime =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

        val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        val material = "com.google.android.material:material:${Versions.material}"
        val activityKtx = "androidx.activity:activity-ktx:${Versions.activity}"
        val kotlinXCoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        val navigationUIKtx =
            "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

        object XML {
            val lifecycleViewModelKtx =
                "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
            val lifecycleViewModelSavedState =
                "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
            val lifecycleRunTimeKtx =
                "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
            val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
            val constraintLayout =
                "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
            val coordinatorLayout =
                "androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorlayout}"
            val swipeRefreshLayout =
                "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swiperefreshlayout}"
            val navigationFragment =
                "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
            val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

        }

        object Compose {
            val androidXActivityCompose =
                "androidx.activity:activity-compose:${Versions.activity}"

            val coil = "io.coil-kt:coil-compose:${Versions.coil}"

            val compiler = "androidx.compose.compiler:compiler:${Versions.compose_compiler}"
            val ui = "androidx.compose.ui:ui:${Versions.compose}"
            val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
            val foundation =
                "androidx.compose.foundation:foundation:${Versions.compose}"
            val material = "androidx.compose.material:material:${Versions.compose}"
            val materialsIconCore =
                "androidx.compose.material:material-icons-core:${Versions.compose}"
            val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:${Versions.compose}"
            val navigation =
                "androidx.navigation:navigation-compose:${Versions.navigation}"
            val constraintLayout =
                "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintlayout_compose}"

            val lifecycleViewModelCompose =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
            val hiltNavigation =
                "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"

            object Accompanist {
                private val base = "com.google.accompanist:accompanist-"
                val systemUIController =
                    "${base}systemuicontroller:${Versions.accompanist}"
                val pager = "${base}pager:${Versions.accompanist}"
                val pagerIndicators = "${base}pager-indicators:${Versions.accompanist}"

                val insets = "${base}insets:${Versions.accompanist}"
                val insetsUI = "${base}insets-ui:${Versions.accompanist}"
                val navigationAnimation =
                    "${base}navigation-animation:${Versions.accompanist}"
                val navigationMaterial =
                    "${base}navigation-material:${Versions.accompanist}"
                val placeholderMaterial =
                    "${base}placeholder-material:${Versions.accompanist}"
            }

        }
    }
}

fun Project.dataDependencies(configuration: DependencyHandlerScope.() -> Unit = {}) {
    dependencies {

        implementation(fileTree(Dependencies.Versions.fileTree))
        coreLibraryDesugaringImplementation(listOf(Dependencies.Common.desugarJdk))

        implementation(Dependencies.Common.hiltAndroid)
        kapt(Dependencies.Common.hiltAndroidCompiler)

        implementation(Dependencies.Common.kotlinXCoroutinesCore)

        implementation(Dependencies.Common.kotlinDateTime)

        implementation(Dependencies.Data.roomKtx)
        ksp(Dependencies.Data.roomCompiler)

        implementation(Dependencies.Common.kotlinSerializationJson)

        implementation(Dependencies.Data.Ktor.clientCore)
        implementation(Dependencies.Data.Ktor.clientAndroid)
        implementation(Dependencies.Data.Ktor.clientSerialization)
        implementation(Dependencies.Data.Ktor.clientLogging)
        implementation(Dependencies.Data.logbackClassic)

        // Serialization

        configuration()
    }
}

fun Project.domainDependencies(configuration: DependencyHandlerScope.() -> Unit = {}) {
    dependencies {

        implementation(fileTree(Dependencies.Versions.fileTree))
        coreLibraryDesugaringImplementation(listOf(Dependencies.Common.desugarJdk))

        implementation(Dependencies.Common.hiltAndroid)
        kapt(Dependencies.Common.hiltAndroidCompiler)

        implementation(Dependencies.Common.kotlinXCoroutinesCore)

        implementation(Dependencies.Common.kotlinDateTime)

        configuration()
    }
}

fun Project.composePresentationDependencies(configuration: DependencyHandlerScope.() -> Unit = {}) {
    dependencies {

        implementation(fileTree(Dependencies.Versions.fileTree))
        coreLibraryDesugaringImplementation(listOf(Dependencies.Common.desugarJdk))

        implementation(Dependencies.Common.hiltAndroid)
        kapt(Dependencies.Common.hiltAndroidCompiler)

        implementation(Dependencies.Common.kotlinXCoroutinesCore)

        implementation(Dependencies.Common.kotlinDateTime)

        ///////////////////

        implementation(Dependencies.Presentation.kotlinXCoroutinesAndroid)
        implementation(Dependencies.Presentation.Compose.androidXActivityCompose)
        implementation(Dependencies.Presentation.Compose.hiltNavigation)

        // Compose
        implementation(Dependencies.Presentation.Compose.compiler)
        implementation(Dependencies.Presentation.Compose.ui)
        implementation(Dependencies.Presentation.Compose.uiTooling)
        implementation(Dependencies.Presentation.Compose.foundation)
        implementation(Dependencies.Presentation.Compose.material)
        implementation(Dependencies.Presentation.Compose.materialsIconCore)
        implementation(Dependencies.Presentation.Compose.materialIconsExtended)
        implementation(Dependencies.Presentation.Compose.navigation)
        implementation(Dependencies.Presentation.Compose.lifecycleViewModelCompose)

        implementation(Dependencies.Presentation.Compose.Accompanist.insets)
        implementation(Dependencies.Presentation.Compose.Accompanist.insetsUI)
        implementation(Dependencies.Presentation.Compose.coil)
        implementation(Dependencies.Presentation.Compose.Accompanist.pager)
        implementation(Dependencies.Presentation.Compose.Accompanist.pagerIndicators)
        implementation(Dependencies.Presentation.Compose.Accompanist.systemUIController)
        implementation(Dependencies.Presentation.Compose.Accompanist.navigationAnimation)
        implementation(Dependencies.Presentation.Compose.Accompanist.navigationMaterial)
        implementation(Dependencies.Presentation.Compose.Accompanist.placeholderMaterial)

        configuration()
    }
}

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}

fun DependencyHandler.implementation(dependency: ConfigurableFileTree) {
    add("implementation", dependency)
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        implementation(dependency)
    }
}

fun DependencyHandler.kapt(dependency: String) {
    add("kapt", dependency)
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        kapt(dependency)
    }
}

fun DependencyHandler.ksp(dependency: String) {
    add("ksp", dependency)
}

fun DependencyHandler.ksp(list: List<String>) {
    list.forEach { dependency ->
        ksp(dependency)
    }
}

fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        androidTestImplementation(dependency)
    }
}

fun DependencyHandler.coreLibraryDesugaringImplementation(dependency: String) {
    add("coreLibraryDesugaring", dependency)
}

fun DependencyHandler.coreLibraryDesugaringImplementation(list: List<String>) {
    list.forEach { dependency ->
        coreLibraryDesugaringImplementation(dependency)
    }
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        testImplementation(dependency)
    }
}