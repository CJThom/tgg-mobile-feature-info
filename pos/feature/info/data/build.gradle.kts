plugins {
    id(Dependencies.Plugins.androidLibrary)
    kotlin(Dependencies.Plugins.kotlinAndroid)
    kotlin(Dependencies.Plugins.kotlinKapt)
    id(Dependencies.Plugins.hiltAndroid)
    id(Dependencies.Plugins.mavenPublish)
}

android {

    namespace = AppBuildConfig.Modules.Internal.Info.Data.directory

    compileSdk = AppBuildConfig.Config.compileSdk

    defaultConfig {
        minSdk = AppBuildConfig.Config.minSdk
        targetSdk = AppBuildConfig.Config.targetSdk
       // testInstrumentationRunner = AppBuildConfig.Config.testInstrumentationRunner
        //consumerProguardFiles(AppBuildConfig.Config.consumerProguardFiles)
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


    buildTypes {

        getByName(BuildTypes.debug) {

        }

        getByName(BuildTypes.release) {
            isMinifyEnabled = false
        }

    }

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

   // implementation(project(AppBuildConfig.Modules.Internal.Info.Domain.dependency))

    //annotationProcessor
    implementation(Dependencies.Common.kotlinXCoroutinesCore)

    //Dagger Hilt
    implementation(Dependencies.Common.hiltAndroid)
    kapt(Dependencies.Common.hiltAndroidCompiler)


}


publishing {
    publications {

        val baseArtifactId = "tgg-mobile-feature-info-data"

        register<MavenPublication>("debug") {

            groupId = TGGBuildConfig.publishingGroupId
            artifactId = baseArtifactId
            version = AppBuildConfig.Config.versionName

            afterEvaluate {
                from(components["debug"])
            }
        }

        register<MavenPublication>("release") {

            groupId = TGGBuildConfig.publishingGroupId
            artifactId = baseArtifactId
            version = AppBuildConfig.Config.versionName

            afterEvaluate {
                from(components["release"])
            }
        }
    }

}
//publishing {
//    publications {
//
//        val baseArtifactId = "tgg-mobile-feature-info-data"
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