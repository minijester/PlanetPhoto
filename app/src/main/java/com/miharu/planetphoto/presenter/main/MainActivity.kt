package com.miharu.planetphoto.presenter.main

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.miharu.planetphoto.core.base.BaseActivity
import com.miharu.planetphoto.core.extension.viewBinding
import com.miharu.planetphoto.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)
    }
}