package com.vlending.applinksdk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.vlending.applink.AppLink
import com.vlending.applink.model.AppLinkInfo
import com.vlending.applink.model.AppLinkUtm

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppLink.setUserId(userId = "YOUR_USER_ID")
        getDeeplinkInfo(intent)

        val buttonGenerate: Button = findViewById(R.id.button_generate)
        buttonGenerate.setOnClickListener {
            generateAppLink()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) getDeeplinkInfo(intent)
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
                AppLink.showShareClip(context = this, url = it)
            }, failedCallback = {
                //DO SOMETHING...
            })
    }

    private fun getDeeplinkInfo(intent: Intent) {
        if (AppLink.isValidationLink(intent.data.toString())) {
            AppLink.getAppLinkInfo(intent, successCallback = { appLinkInfo, code, urlQuery  ->
                Log.d("AppLink", "code = $code, urlQuery = $urlQuery")
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