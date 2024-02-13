package com.example.daggerlearning.service.notificationservice

import android.util.Log
import com.example.daggerlearning.service.Constant.DAGGER_LEARNING
import com.example.daggerlearning.service.di.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService {
    fun send(destination: String, message: String, body: String)
}

@ActivityScope
class EmailNotificationService @Inject constructor() : NotificationService {
    override fun send(email: String, message: String, body: String) {
        Log.d(DAGGER_LEARNING, "Email send to $email with message : $message")
    }
}

class PhoneNotificationService(private val retryCount:Int) : NotificationService {
    override fun send(phone: String, message: String, body: String) {
        Log.d(DAGGER_LEARNING, "Message send to $phone with message : $message $retryCount")
    }
}