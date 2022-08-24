package com.thegoodguys.pos.feature.info.app


import com.thegoodguys.pos.core.common.util.ApplicationBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TGGMobileFeatureInfoApplication : ApplicationBase() {

    override fun getSessionDurationTimeInMinutes(): Int {
        return 5
    }

    override fun getAnalyticsTrackerId(): Int? {
        return null
    }

    override fun getBuildConfigIsDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    override fun getIsAnalyticsEnabled(): Boolean? {
        return null
    }

}