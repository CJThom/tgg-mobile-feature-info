plugins {
    id(Dependencies.Plugins.androidLibrary)
    kotlin(Dependencies.Plugins.kotlinAndroid)
    kotlin(Dependencies.Plugins.kotlinKapt)
    id(Dependencies.Plugins.hiltAndroid)
    id(Dependencies.Plugins.mavenPublish)
}

android {

    namespace = AppBuildConfig.Modules.Internal.Info.Presentation.directory

    compileSdk = AppBuildConfig.Config.compileSdk

    defaultConfig {
        minSdk = AppBuildConfig.Config.minSdk
        targetSdk = AppBuildConfig.Config.targetSdk
        //testInstrumentationRunner = AppBuildConfig.Config.testInstrumentationRunner
        //consumerProguardFiles(AppBuildConfig.Config.consumerProguardFiles)
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = Dependencies.Versions.java
        targetCompatibility = Dependencies.Versions.java
    }

    kotlinOptions {
        jvmTarget = Dependencies.Versions.jvm
    }

    hilt {
        enableAggregatingTask = true
    }

    kapt {
        correctErrorTypes = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.compose_compiler
    }


    buildTypes {

        getByName(BuildTypes.debug) {

        }

        getByName(BuildTypes.release) {
            isMinifyEnabled = false
        }

    }
//
//    flavorDimensions.add(TGGBuildConfig.Flavors.versionDimension)
//    productFlavors {
//
//        create(TGGBuildConfig.Flavors.OFFLINE.name) {
//            dimension = TGGBuildConfig.Flavors.versionDimension
//        }
//
//        create(TGGBuildConfig.Flavors.DEV.name) {
//            dimension = TGGBuildConfig.Flavors.versionDimension
//        }
//
//        create(TGGBuildConfig.Flavors.TST.name) {
//            dimension = TGGBuildConfig.Flavors.versionDimension
//        }
//
//        create(TGGBuildConfig.Flavors.UAT.name) {
//            dimension = TGGBuildConfig.Flavors.versionDimension
//        }
//        create(TGGBuildConfig.Flavors.PRD.name) {
//            dimension = TGGBuildConfig.Flavors.versionDimension
//        }
//
//    }

    publishing {
//        singleVariant("debug") {
//            withSourcesJar()
//        }
        singleVariant("release") {
            withSourcesJar()
        }
    }
//    publishing {
//
//        singleVariant("${TGGBuildConfig.Flavors.OFFLINE.name}Debug") {
//            withSourcesJar()
//        }
//        singleVariant("${TGGBuildConfig.Flavors.OFFLINE.name}Release") {
//            withSourcesJar()
//        }
//
//        singleVariant("${TGGBuildConfig.Flavors.DEV.name}Debug") {
//            withSourcesJar()
//        }
//        singleVariant("${TGGBuildConfig.Flavors.DEV.name}Release") {
//            withSourcesJar()
//        }
//
//        singleVariant("${TGGBuildConfig.Flavors.TST.name}Debug") {
//            withSourcesJar()
//        }
//        singleVariant("${TGGBuildConfig.Flavors.TST.name}Release") {
//            withSourcesJar()
//        }
//
//        singleVariant("${TGGBuildConfig.Flavors.UAT.name}Debug") {
//            withSourcesJar()
//        }
//        singleVariant("${TGGBuildConfig.Flavors.UAT.name}Release") {
//            withSourcesJar()
//        }
//
//        singleVariant("${TGGBuildConfig.Flavors.PRD.name}Debug") {
//            withSourcesJar()
//        }
//        singleVariant("${TGGBuildConfig.Flavors.PRD.name}Release") {
//            withSourcesJar()
//        }
//
//    }

}

dependencies {

    implementation(fileTree(Dependencies.Versions.fileTree))

  //  implementation(project(AppBuildConfig.Modules.Internal.Info.Domain.dependency))

    implementation(Dependencies.Modules.Core.common(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))
    implementation(Dependencies.Modules.Core.domain(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))
    implementation(Dependencies.Modules.Core.compose(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))

    implementation(Dependencies.Presentation.Compose.Accompanist.insetsUI)
    // implementation(Dependencies.Presentation.Compose.Accompanist.systemUIController)
    implementation(Dependencies.Presentation.Compose.Accompanist.placeholderMaterial)

    // Compose
    implementation(Dependencies.Presentation.Compose.compiler)
    implementation(Dependencies.Presentation.Compose.ui)
    implementation(Dependencies.Presentation.Compose.uiTooling)
    implementation(Dependencies.Presentation.Compose.foundation)
    implementation(Dependencies.Presentation.Compose.material)
    implementation(Dependencies.Presentation.Compose.materialsIconCore)
    implementation(Dependencies.Presentation.Compose.materialIconsExtended)
    // implementation(Dependencies.Presentation.Compose.navigation)

//    implementation("androidx.customview:customview:1.2.0-alpha01")
//    implementation("androidx.customview:customview-poolingcontainer:1.0.0-alpha01")

    debugImplementation("androidx.customview:customview:1.2.0-alpha01")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0")

    implementation(Dependencies.Presentation.Compose.lifecycleViewModelCompose)

    implementation(Dependencies.Presentation.Compose.hiltNavigation)

    //implementation(Dependencies.Presentation.androidx_appcompat)

    //Kotlin Coroutines
    implementation(Dependencies.Presentation.kotlinXCoroutinesAndroid)
    implementation(Dependencies.Common.kotlinXCoroutinesCore)

    //Dagger Hilt
    implementation(Dependencies.Common.hiltAndroid)
    kapt(Dependencies.Common.hiltAndroidCompiler)

}


publishing {
    publications {

        val baseArtifactId = "tgg-mobile-feature-info-presentation"

//        register<MavenPublication>("debug") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["debug"])
//            }
//        }

        register<MavenPublication>("release") {

//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName

            afterEvaluate {
                from(components["release"])
            }
        }
    }

}

//
//publishing {
//    publications {
//
//        val baseArtifactId = "tgg-mobile-feature-info-presentation"
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.OFFLINE.name}Debug") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.OFFLINE.name}Debug"])
//            }
//        }
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.OFFLINE.name}Release") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.OFFLINE.name}Release"])
//            }
//        }
//
//        ///////////////////////////////////////////////////
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.DEV.name}Debug") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.DEV.name}Debug"])
//            }
//        }
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.DEV.name}Release") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.DEV.name}Release"])
//            }
//        }
//
//        ///////////////////////////////////////////////////
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.TST.name}Debug") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.TST.name}Debug"])
//            }
//        }
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.TST.name}Release") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.TST.name}Release"])
//            }
//        }
//
//        ///////////////////////////////////////////////////
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.UAT.name}Debug") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.UAT.name}Debug"])
//            }
//        }
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.UAT.name}Release") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.UAT.name}Release"])
//            }
//        }
//
//        ///////////////////////////////////////////////////
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.PRD.name}Debug") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.PRD.name}Debug"])
//            }
//        }
//
//        register<MavenPublication>("${TGGBuildConfig.Flavors.PRD.name}Release") {
//
//            groupId = TGGBuildConfig.publishingGroupId
//            artifactId = baseArtifactId
//            version = AppBuildConfig.Config.versionName
//
//            afterEvaluate {
//                from(components["${TGGBuildConfig.Flavors.PRD.name}Release"])
//            }
//        }
//
//    }
//
//}
