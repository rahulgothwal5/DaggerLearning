package com.example.daggerlearning.service

import android.content.ContentValues.TAG
import android.util.Log
import com.example.daggerlearning.service.Constant.DAGGER_LEARNING
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository {
    fun saveUser(email: String, password: String)
}

@Singleton
class SqlUserRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(DAGGER_LEARNING, "User saved in DB")
    }
}

class FirebaseUserRepository @Inject constructor() : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(DAGGER_LEARNING, "User saved in Firebase")
    }
}