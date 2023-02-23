@file:Suppress("unused")

package ru.mrz.core.common.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

const val LAUNCH_BROWSER_TAG = "launch_browser"

fun Context.launchBrowser(link: String) {
    runCatching {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        this.startActivity(intent, null)
    }.onFailure {
        Log.d(LAUNCH_BROWSER_TAG, "${it.message}")
    }
}
