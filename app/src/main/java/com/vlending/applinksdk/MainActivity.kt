package com.vlending.applinksdk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.vlending.mubeatapplink.AppLink
import com.vlending.mubeatapplink.model.AppLinkInfo
import com.vlending.mubeatapplink.model.AppLinkUtm

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppLink.setNetwork(baseUrl = "YOUR_BASE_URL", apiKey = "YOUR_API_KEY")
        AppLink.setUserId(userId = "YOUR_USER_ID")
        AppLink.customScheme = "YOUR_CUSTOM_SCHEME"
        getDeeplinkInfo(intent)

        val buttonGenerate: Button = findViewById(R.id.button_generate)
        buttonGenerate.setOnClickListener {
            generateAppLink()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        getDeeplinkInfo(intent)
    }

    private fun generateAppLink() {
        AppLink.generateAppLink(
            AppLinkInfo(
                appLinkUtm = AppLinkUtm("CAMPAIGN_NAME", "UTM_MEDIUM", "UTM_SOURCE"),
                webUrl = "WEB_URL",
                action = "ACTION",
                imageUrl = "IMAGE_URL",
                title = "TITLE",
                description = "DESCRIPTION"
            ), successCallback = {
                AppLink.showShareClip(context = this, url = it.url)
            }, failedCallback = {
                //DO SOMETHING...
            })
    }

    private fun getDeeplinkInfo(intent: Intent?) {
        if (AppLink.isValidationLink(intent?.data.toString())) {
            AppLink.getAppLinkInfo(intent, successCallback = { appLinkInfo ->
                when (appLinkInfo.scheme) {
                    AppLink.customScheme -> {
                        if (appLinkInfo.action == "ACTION") {
                            //DO SOMETHING...
                        } else {
                            //DO SOMETHING...
                        }
                    }
                }
            }, failedCallback = {
                //DO SOMETHING...
            })
        }
    }
}