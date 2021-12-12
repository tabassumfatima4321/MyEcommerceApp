package com.dawaai.myecommerceapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.dawaai.myecommerceapp.R
import com.dawaai.myecommerceapp.databinding.ActivitySplashBinding
import com.dawaai.myecommerceapp.helper.SPLASH_SCREEN_DURATION
import com.dawaai.myecommerceapp.helper.navigateToActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViews()
    }
    private fun setViews()
    {
        binding.imageViewLauncher.animation=AnimationUtils.loadAnimation(this,R.anim.top_animation)
        binding.tvMyExpress.animation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation)
        Handler(Looper.getMainLooper()).postDelayed({
        this.navigateToActivity(HomeActivity::class.java)
        }, SPLASH_SCREEN_DURATION)

    }
}