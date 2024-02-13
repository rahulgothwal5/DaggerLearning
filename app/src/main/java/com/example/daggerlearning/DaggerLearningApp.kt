package com.example.daggerlearning

import android.app.Application

class DaggerLearningApp:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}