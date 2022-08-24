import org.gradle.api.component.SoftwareComponent
import org.gradle.api.publish.maven.MavenPublication

object BuildTypes {
    const val debug = "debug"
    const val release = "release"
}

object BuildConfigTypes {
    const val string = "String"
    const val int = "int"
}

open class ResValues {
    open class AppName(
        val type: String = "string",
        val name: String = "app_name"
    )
}

open class ManifestPlaceholders {
    open class DataWedgeIntentFilter(
        val type: String = "string",
        val name: String = "dataWedgeIntentFilter"
    )
}


fun MavenPublication.setMavenPublication(
    groupId: String,
    artifactId: String,
    version: String,
    softwareComponent: SoftwareComponent
) {
    from(softwareComponent)
    this.groupId = groupId
    this.artifactId = artifactId
    this.version = version
}

object TGGBuildConfig {

    const val publishingGroupId = "com.github.TGG-Dev"

    object BasicUsername {
        const val type: String = BuildConfigTypes.string
        const val name: String = "basicUsername"
        const val value: String = "\"MPOS_SERVICES\""
    }

    object DBVersions {
        const val type: String = BuildConfigTypes.int
        const val name: String = "db"
        const val value: String = "1"
    }

    object BasicAuthPasswords {
        const val PRD = "ZDb60hMSUsudNm4Sy"
        const val NON_PRD = "aBb1LxDM58KLczWWl"
    }

    object BasePOSURL_1 {
        const val PRD = "https://tggvprdpos.tgglocal.com.au/"
        const val UAT = "https://tggvuatpos.tgglocal.com.au/"
        const val TST = "https://tggtstpos01.tgglocal.com.au/"
        const val DEV = "http://tggposdev10.tgglocal.com.au:8052/"
    }

    object BasePOSURL_2 {
        const val PRD = "http://tggnpdposprd02.tgglocal.com.au:9012/"
        const val UAT = "http://tggnpdposuat02.tgglocal.com.au:9012/"
        const val TST = "http://tggnpdpostst02.tgglocal.com.au:9012/"
        const val DEV = "http://tggposdev10.tgglocal.com.au:8015/"
    }

    object Flavors {
        const val versionDimension = "version"

        object PRD {
            const val name = "prd"
            const val suffix = ".prd"

            object EnvironmentName : BuildConfigFields.EnvironmentName() {
                const val value: String = "\"Production\""
            }

            object AppName : ResValues.AppName()

            object BasePOSURL_1 : BuildConfigFields.BasePOSURL_1() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_1.PRD}\""
            }

            object BasePOSURL_2 : BuildConfigFields.BasePOSURL_2() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_2.PRD}\""
            }

            object BasicPassword : BuildConfigFields.BasicPassword() {
                const val value: String = "\"${TGGBuildConfig.BasicAuthPasswords.PRD}\""
            }

        }

        object UAT {
            const val name = "uat"
            const val suffix = ".uat"

            object EnvironmentName : BuildConfigFields.EnvironmentName() {
                const val value: String = "\"User Acceptance Test\""
            }

            object AppName : ResValues.AppName()

            object BasePOSURL_1 : BuildConfigFields.BasePOSURL_1() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_1.UAT}\""
            }

            object BasePOSURL_2 : BuildConfigFields.BasePOSURL_2() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_2.UAT}\""
            }

            object BasicPassword : BuildConfigFields.BasicPassword() {
                const val value: String = "\"${TGGBuildConfig.BasicAuthPasswords.NON_PRD}\""
            }

        }

        object TST {
            const val name = "tst"
            const val suffix = ".tst"

            object EnvironmentName : BuildConfigFields.EnvironmentName() {
                const val value: String = "\"Test\""
            }

            object AppName : ResValues.AppName()

            object BasePOSURL_1 : BuildConfigFields.BasePOSURL_1() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_1.TST}\""
            }

            object BasePOSURL_2 : BuildConfigFields.BasePOSURL_2() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_2.TST}\""
            }

            object BasicPassword : BuildConfigFields.BasicPassword() {
                const val value: String = "\"${TGGBuildConfig.BasicAuthPasswords.NON_PRD}\""
            }

        }

        object DEV {
            const val name = "dev"
            const val suffix = ".dev"

            object EnvironmentName : BuildConfigFields.EnvironmentName() {
                const val value: String = "\"Develop\""
            }

            object AppName : ResValues.AppName()

            object BasePOSURL_1 : BuildConfigFields.BasePOSURL_1() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_1.DEV}\""
            }

            object BasePOSURL_2 : BuildConfigFields.BasePOSURL_2() {
                const val value: String = "\"${TGGBuildConfig.BasePOSURL_2.DEV}\""
            }

            object BasicPassword : BuildConfigFields.BasicPassword() {
                const val value: String = "\"${TGGBuildConfig.BasicAuthPasswords.NON_PRD}\""
            }

        }

        object OFFLINE {
            const val name = "offline"
            const val suffix = ".offline"

            object EnvironmentName : BuildConfigFields.EnvironmentName() {
                const val value: String = "\"OFFLINE\""
            }

            object AppName : ResValues.AppName()

            object BasePOSURL_1 : BuildConfigFields.BasePOSURL_1() {
                const val value: String = Flavors.DEV.BasePOSURL_1.value
            }

            object BasePOSURL_2 : BuildConfigFields.BasePOSURL_2() {
                const val value: String = Flavors.DEV.BasePOSURL_2.value
            }

            object BasicPassword : BuildConfigFields.BasicPassword() {
                const val value: String = Flavors.DEV.BasicPassword.value
            }

        }
    }

    open class BuildConfigFields {

        open class BasePOSURL_1(
            val type: String = BuildConfigTypes.string,
            val name: String = "basePOSURL_1"
        )

        open class BasePOSURL_2(
            val type: String = BuildConfigTypes.string,
            val name: String = "basePOSURL_2"
        )

        open class BasicPassword {
            val type: String = BuildConfigTypes.string
            val name: String = "basicPassword"
        }

        open class EnvironmentName(
            val type: String = BuildConfigTypes.string,
            val name: String = "ENVIRONMENT_NAME"
        )

        open class DataWedgeProfileName(
            val type: String = BuildConfigTypes.string,
            val name: String = "datawedge_profile_Name"
        )

        open class DataWedgeIntentFilter(
            val type: String = BuildConfigTypes.string,
            val name: String = "datawedge_intent_filter"
        )

    }

}

