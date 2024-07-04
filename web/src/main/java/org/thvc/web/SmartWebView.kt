package org.thvc.web

import android.webkit.WebView
import org.thvc.domain.WebViewUrl

class SmartWebView (
    private val webView: WebView,
){
    fun load(url: WebViewUrl) {
        webView.loadUrl(url.value)
    }
}