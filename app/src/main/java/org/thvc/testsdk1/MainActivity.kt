package org.thvc.testsdk1

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import org.thvc.sdk.WebViewFragment
import org.thvc.testsdk1.databinding.MainActivityLayoutBinding

class MainActivity : Activity() {
    private lateinit var layoutBinding : MainActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = MainActivityLayoutBinding.inflate(LayoutInflater.from(this))
        setContentView(layoutBinding.root)
    }

}
