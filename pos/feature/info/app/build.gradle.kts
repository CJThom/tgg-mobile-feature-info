plugins {
    id(Dependencies.Plugins.androidApplication)
    kotlin(Dependencies.Plugins.kotlinAndroid)
    kotlin(Dependencies.Plugins.kotlinKapt)
    id(Dependencies.Plugins.hiltAndroid)
}

android {
    compileSdk = AppBuildConfig.Config.compileSdk

    defaultConfig {
        applicationId = AppBuildConfig.Config.applicationId
        minSdk = AppBuildConfig.Config.minSdk
        targetSdk = AppBuildConfig.Config.targetSdk
        versionCode = AppBuildConfig.Config.versionCode
        versionName = AppBuildConfig.Config.versionName
        testInstrumentationRunner = AppBuildConfig.Config.testInstrumentationRunner
    }

    buildFeatures {
        compose = true
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

    defaultConfig {
        buildConfigField(
            TGGBuildConfig.BasicUsername.type,
            TGGBuildConfig.BasicUsername.name,
            TGGBuildConfig.BasicUsername.value
        )
        buildConfigField(
            TGGBuildConfig.DBVersions.type,
            TGGBuildConfig.DBVersions.name,
            TGGBuildConfig.DBVersions.value
        )

    }

    buildTypes {

        getByName(BuildTypes.debug) {
            isDebuggable = true
        }

        getByName(BuildTypes.release) {
            isMinifyEnabled = false
            isDebuggable = false
        }

        applicationVariants.all {
            outputs.all {
                (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName = "feature_info-${name}-${versionName}.apk"
            }
        }
    }

    flavorDimensions.add(TGGBuildConfig.Flavors.versionDimension)
    productFlavors {


        create(TGGBuildConfig.Flavors.PRD.name) {
            dimension = TGGBuildConfig.Flavors.versionDimension
            buildConfigField(
                TGGBuildConfig.Flavors.PRD.BasePOSURL_1.type,
                TGGBuildConfig.Flavors.PRD.BasePOSURL_1.name,
                TGGBuildConfig.Flavors.PRD.BasePOSURL_1.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.PRD.BasePOSURL_2.type,
                TGGBuildConfig.Flavors.PRD.BasePOSURL_2.name,
                TGGBuildConfig.Flavors.PRD.BasePOSURL_2.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.PRD.BasicPassword.type,
                TGGBuildConfig.Flavors.PRD.BasicPassword.name,
                TGGBuildConfig.Flavors.PRD.BasicPassword.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.PRD.EnvironmentName.type,
                TGGBuildConfig.Flavors.PRD.EnvironmentName.name,
                TGGBuildConfig.Flavors.PRD.EnvironmentName.value,
            )
            resValue(
                TGGBuildConfig.Flavors.PRD.AppName.type,
                TGGBuildConfig.Flavors.PRD.AppName.name,
                TGGBuildConfig.Flavors.PRD.AppName.value
            )
            applicationIdSuffix = TGGBuildConfig.Flavors.PRD.suffix
        }

        create(TGGBuildConfig.Flavors.UAT.name) {
            dimension = TGGBuildConfig.Flavors.versionDimension
            buildConfigField(
                TGGBuildConfig.Flavors.UAT.BasePOSURL_1.type,
                TGGBuildConfig.Flavors.UAT.BasePOSURL_1.name,
                TGGBuildConfig.Flavors.UAT.BasePOSURL_1.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.UAT.BasePOSURL_2.type,
                TGGBuildConfig.Flavors.UAT.BasePOSURL_2.name,
                TGGBuildConfig.Flavors.UAT.BasePOSURL_2.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.UAT.BasicPassword.type,
                TGGBuildConfig.Flavors.UAT.BasicPassword.name,
                TGGBuildConfig.Flavors.UAT.BasicPassword.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.UAT.EnvironmentName.type,
                TGGBuildConfig.Flavors.UAT.EnvironmentName.name,
                TGGBuildConfig.Flavors.UAT.EnvironmentName.value,
            )
            resValue(
                TGGBuildConfig.Flavors.UAT.AppName.type,
                TGGBuildConfig.Flavors.UAT.AppName.name,
                TGGBuildConfig.Flavors.UAT.AppName.value
            )
            applicationIdSuffix = TGGBuildConfig.Flavors.UAT.suffix
        }

        create(TGGBuildConfig.Flavors.TST.name) {
            dimension = TGGBuildConfig.Flavors.versionDimension
            buildConfigField(
                TGGBuildConfig.Flavors.TST.BasePOSURL_1.type,
                TGGBuildConfig.Flavors.TST.BasePOSURL_1.name,
                TGGBuildConfig.Flavors.TST.BasePOSURL_1.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.TST.BasePOSURL_2.type,
                TGGBuildConfig.Flavors.TST.BasePOSURL_2.name,
                TGGBuildConfig.Flavors.TST.BasePOSURL_2.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.TST.BasicPassword.type,
                TGGBuildConfig.Flavors.TST.BasicPassword.name,
                TGGBuildConfig.Flavors.TST.BasicPassword.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.TST.EnvironmentName.type,
                TGGBuildConfig.Flavors.TST.EnvironmentName.name,
                TGGBuildConfig.Flavors.TST.EnvironmentName.value,
            )
            resValue(
                TGGBuildConfig.Flavors.TST.AppName.type,
                TGGBuildConfig.Flavors.TST.AppName.name,
                TGGBuildConfig.Flavors.TST.AppName.value
            )
            applicationIdSuffix = TGGBuildConfig.Flavors.TST.suffix
        }

        create(TGGBuildConfig.Flavors.DEV.name) {
            dimension = TGGBuildConfig.Flavors.versionDimension
            buildConfigField(
                TGGBuildConfig.Flavors.DEV.BasePOSURL_1.type,
                TGGBuildConfig.Flavors.DEV.BasePOSURL_1.name,
                TGGBuildConfig.Flavors.DEV.BasePOSURL_1.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.DEV.BasePOSURL_2.type,
                TGGBuildConfig.Flavors.DEV.BasePOSURL_2.name,
                TGGBuildConfig.Flavors.DEV.BasePOSURL_2.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.DEV.BasicPassword.type,
                TGGBuildConfig.Flavors.DEV.BasicPassword.name,
                TGGBuildConfig.Flavors.DEV.BasicPassword.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.DEV.EnvironmentName.type,
                TGGBuildConfig.Flavors.DEV.EnvironmentName.name,
                TGGBuildConfig.Flavors.DEV.EnvironmentName.value,
            )
            resValue(
                TGGBuildConfig.Flavors.DEV.AppName.type,
                TGGBuildConfig.Flavors.DEV.AppName.name,
                TGGBuildConfig.Flavors.DEV.AppName.value
            )
            applicationIdSuffix = TGGBuildConfig.Flavors.DEV.suffix
        }

        create(TGGBuildConfig.Flavors.OFFLINE.name) {
            dimension = TGGBuildConfig.Flavors.versionDimension
            buildConfigField(
                TGGBuildConfig.Flavors.OFFLINE.BasePOSURL_1.type,
                TGGBuildConfig.Flavors.OFFLINE.BasePOSURL_1.name,
                TGGBuildConfig.Flavors.OFFLINE.BasePOSURL_1.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.OFFLINE.BasePOSURL_2.type,
                TGGBuildConfig.Flavors.OFFLINE.BasePOSURL_2.name,
                TGGBuildConfig.Flavors.OFFLINE.BasePOSURL_2.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.OFFLINE.BasicPassword.type,
                TGGBuildConfig.Flavors.OFFLINE.BasicPassword.name,
                TGGBuildConfig.Flavors.OFFLINE.BasicPassword.value,
            )
            buildConfigField(
                TGGBuildConfig.Flavors.OFFLINE.EnvironmentName.type,
                TGGBuildConfig.Flavors.OFFLINE.EnvironmentName.name,
                TGGBuildConfig.Flavors.OFFLINE.EnvironmentName.value,
            )
            resValue(
                TGGBuildConfig.Flavors.OFFLINE.AppName.type,
                TGGBuildConfig.Flavors.OFFLINE.AppName.name,
                TGGBuildConfig.Flavors.OFFLINE.AppName.value
            )
            applicationIdSuffix = TGGBuildConfig.Flavors.OFFLINE.suffix
        }
    }
}

dependencies {

    implementation(project(AppBuildConfig.Modules.Internal.Info.Presentation.dependency))

    implementation(Dependencies.Modules.Core.compose(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))
    implementation(Dependencies.Modules.Core.common(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))
    implementation(Dependencies.Modules.Core.domain(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))
    implementation(Dependencies.Modules.Core.presentation(AppBuildConfig.Modules.External.Versions.tggmobilecorepos))

//    implementation(Dependencies.Modules.Login.data(AppBuildConfig.Modules.External.Versions.tggmobilefeaturelogin))
//    implementation(Dependencies.Modules.Login.domain(AppBuildConfig.Modules.External.Versions.tggmobilefeaturelogin))
//    implementation(Dependencies.Modules.Login.presentation(AppBuildConfig.Modules.External.Versions.tggmobilefeaturelogin))

    implementation(fileTree(Dependencies.Versions.fileTree))

  //  coreLibraryDesugaring(Dependencies.Common.desugarJdk)

    implementation(Dependencies.Presentation.Compose.androidXActivityCompose)

  //  implementation(Dependencies.Presentation.Compose.Accompanist.insets)
    implementation(Dependencies.Presentation.Compose.Accompanist.insetsUI)
    implementation(Dependencies.Presentation.Compose.Accompanist.systemUIController)

    // Compose
    implementation(Dependencies.Presentation.Compose.compiler)
    implementation(Dependencies.Presentation.Compose.ui)
    implementation(Dependencies.Presentation.Compose.uiTooling)
    implementation(Dependencies.Presentation.Compose.foundation)
    implementation(Dependencies.Presentation.Compose.material)
    implementation(Dependencies.Presentation.Compose.materialsIconCore)
    implementation(Dependencies.Presentation.Compose.materialIconsExtended)
   
    implementation(Dependencies.Presentation.Compose.lifecycleViewModelCompose)
    implementation(Dependencies.Presentation.Compose.navigation)


    //Dagger Hilt
    implementation(Dependencies.Common.hiltAndroid)
    kapt(Dependencies.Common.hiltAndroidCompiler)

    implementation(Dependencies.Presentation.Compose.hiltNavigation)

    //Kotlin Coroutines
    implementation(Dependencies.Common.kotlinXCoroutinesCore)



}