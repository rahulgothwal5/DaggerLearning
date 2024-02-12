package com.example.daggerlearning.service

import com.example.daggerlearning.MainActivity
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [UserRepositoryModule::class,NotificationServiceModule::class])
interface UserRegistrationServiceComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount: Int):UserRegistrationServiceComponent
    }
}