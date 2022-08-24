package com.thegoodguys.pos.feature.info.app.di


import android.content.Context
import com.thegoodguys.pos.core.domain.model.AppBuildConfig
import com.thegoodguys.pos.core.domain.model.Flavor
import com.thegoodguys.pos.feature.info.app.BuildConfig
import com.thegoodguys.pos.feature.info.app.R


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFlavor(): Flavor {
        return when (BuildConfig.FLAVOR) {
            Flavor.PRD.value -> Flavor.PRD
            Flavor.UAT.value -> Flavor.UAT
            Flavor.TST.value -> Flavor.TST
            Flavor.DEV.value -> Flavor.DEV
            Flavor.OFFLINE.value -> Flavor.OFFLINE
            else -> throw NullPointerException("Invalid Flavor")
        }
    }

    @Provides
    @Singleton
    fun provideAppBuildConfig(
        @ApplicationContext context: Context,
        flavor: Flavor
    ): AppBuildConfig {
        return AppBuildConfig(
            appName = context.getString(R.string.app_name),
            versionName = BuildConfig.VERSION_NAME,
            environmentName = BuildConfig.ENVIRONMENT_NAME,
            basePOSURL_1 = BuildConfig.basePOSURL_1,
            basePOSURL_2 = BuildConfig.basePOSURL_2,
            baseMWURL_1 = "",
            basicUsername = BuildConfig.basicUsername,
            basicPassword = BuildConfig.basicPassword,
            flavor = flavor,
            posCertificateResourceId = when (flavor) {
                Flavor.PRD -> R.raw.tggvprdpos
                Flavor.UAT -> R.raw.tggvuatpos
                Flavor.TST -> R.raw.tggtstpos
                Flavor.DEV -> R.raw.tggdevpos
                Flavor.OFFLINE -> R.raw.tggdevpos
            },
            mwCertificateResourceId = when (flavor) {
                Flavor.PRD -> R.raw.tggprdmw
                Flavor.UAT -> R.raw.tgguatmw
                Flavor.TST -> R.raw.tggtstmw
                Flavor.DEV -> R.raw.tggdevmw
                Flavor.OFFLINE -> R.raw.tggdevmw
            }
        )
    }

}
