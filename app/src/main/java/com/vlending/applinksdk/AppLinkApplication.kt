package com.vlending.applinksdk

import android.app.Application
import com.vlending.mubeatapplink.AppLink

class AppLinkApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AppLink.setNetwork(baseUrl = "YOUR_BASE_URL", apiKey = "YOUR_API_KEY")
        AppLink.setCustomScheme("YOUR_CUSTOM_SCHEME")
    }
}