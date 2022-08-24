import java.util.*

object AppBuildConfig {
    const val APP_NAME = "Feature Info"
    const val rootDirectory = "com.thegoodguys.pos.feature.info"

    object Config {
        const val compileSdk = 32
        const val applicationId = "com.thegoodguys.ocpos"
        const val minSdk = 25
        const val targetSdk = 32
        const val versionCode = 1
        const val versionName = "import-test-1"
        const val testInstrumentationRunner = "com.thegoodguys.tgg.TGGTestRunner"
        const val consumerProguardFiles = "consumer-rules.pro"
    }

    object Modules {

        object External {
            object Versions {
                const val tggmobilecorepos = "1.3.0-alpha26"
                const val tggmobilefeaturelogin = "1.2.0-alpha06"
            }
        }

        object Internal {

            private const val rootDependency = ":pos:feature"

            object Info {

                private const val loginRootDependency = "$rootDependency:info"

                object Data {
                    const val value = "data"
                    const val directory = "$rootDirectory.$value"
                    const val dependency = "$loginRootDependency:$value"
                }

                object Domain {
                    const val value = "domain"
                    const val directory = "$rootDirectory.$value"
                    const val dependency = "$loginRootDependency:$value"
                }

                object Presentation {
                    const val value = "presentation"
                    const val directory = "$rootDirectory.$value"
                    const val dependency = "$loginRootDependency:$value"
                }

            }

        }
    }
}


val TGGBuildConfig.Flavors.PRD.AppName.value: String
    get() = "\"${AppBuildConfig.APP_NAME} - ${TGGBuildConfig.Flavors.PRD.name.toUpperCase(Locale.ROOT)}\""

val TGGBuildConfig.Flavors.UAT.AppName.value: String
    get() = "\"${AppBuildConfig.APP_NAME} - ${TGGBuildConfig.Flavors.UAT.name.toUpperCase(Locale.ROOT)}\""

val TGGBuildConfig.Flavors.TST.AppName.value: String
    get() = "\"${AppBuildConfig.APP_NAME} - ${TGGBuildConfig.Flavors.TST.name.toUpperCase(Locale.ROOT)}\""

val TGGBuildConfig.Flavors.DEV.AppName.value: String
    get() = "\"${AppBuildConfig.APP_NAME} - ${TGGBuildConfig.Flavors.DEV.name.toUpperCase(Locale.ROOT)}\""

val TGGBuildConfig.Flavors.OFFLINE.AppName.value: String
    get() = "\"${AppBuildConfig.APP_NAME} - ${
        TGGBuildConfig.Flavors.OFFLINE.name.toUpperCase(
            Locale.ROOT
        )
    }\""
