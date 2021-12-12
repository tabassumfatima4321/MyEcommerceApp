package com.dawaai.myecommerceapp.activity

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EcommerceApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}