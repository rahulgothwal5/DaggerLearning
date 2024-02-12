package com.example.daggerlearning.service

import android.content.ContentValues
import android.util.Log
import com.example.daggerlearning.service.Constant.DAGGER_LEARNING
import javax.inject.Inject

interface NotificationService {
    fun send(destination: String, message: String, body: String)
}

class EmailNotificationService @Inject constructor() : NotificationService {
    override fun send(email: String, message: String, body: String) {
        Log.d(DAGGER_LEARNING, "Email send to $email with message : $message")
    }
}

class PhoneNotificationService : NotificationService {
    override fun send(phone: String, message: String, body: String) {
        Log.d(DAGGER_LEARNING, "Message send to $phone with message : $message")
    }
}