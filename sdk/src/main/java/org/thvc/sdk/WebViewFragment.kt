package org.thvc.sdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.thvc.domain.WebViewUrl
import org.thvc.web.SmartWebView
import org.thvc.web.databinding.WebviewFragmentBinding

class WebViewFragment : Fragment() {

    private lateinit var smartWebView: SmartWebView
    private lateinit var layoutBinding: WebviewFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layoutBinding = WebviewFragmentBinding.inflate(inflater, container, false)
        smartWebView = SmartWebView(layoutBinding.webView)
        return layoutBinding.root
    }

    override fun onResume() {
        super.onResume()
        smartWebView.load(WebViewUrl("https://www.telus.com/en/health"))
    }
}