package com.example.daggerlearning.service.analyticsService

import android.util.Log
import com.example.daggerlearning.service.Constant

interface AnalyticsService {
    fun trackEvents(eventName: String, eventType: String)
}

class Mixpanel : AnalyticsService {
    override fun trackEvents(eventName: String, eventType: String) {
        Log.d(Constant.DAGGER_LEARNING, "Mixpanel : Event Name is :$eventName with eventType : $eventType")
    }
}

class Firebase : AnalyticsService {
    override fun trackEvents(eventName: String, eventType: String) {
        Log.d(Constant.DAGGER_LEARNING, "Firebase : Event Name is :$eventName with eventType : $eventType")
    }
}