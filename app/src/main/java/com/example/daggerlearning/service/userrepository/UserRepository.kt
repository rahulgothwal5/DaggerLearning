package com.example.daggerlearning.service.userrepository

import android.util.Log
import com.example.daggerlearning.service.Constant.DAGGER_LEARNING
import com.example.daggerlearning.service.analyticsService.AnalyticsService
import com.example.daggerlearning.service.di.ActivityScope
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository {
    fun saveUser(email: String, password: String)
}

@ActivityScope
class SqlUserRepository @Inject constructor(private val analyticsService: AnalyticsService) :
    UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(DAGGER_LEARNING, "User saved in DB")
        analyticsService.trackEvents("Save User", "CREATE")
    }
}

class FirebaseUserRepository (private val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(DAGGER_LEARNING, "User saved in Firebase")
        analyticsService.trackEvents("Save User", "CREATE")
    }
}