package com.example.daggerlearning.service

import com.example.daggerlearning.MainActivity
import dagger.Component


@Component(modules = [UserRepositoryModule::class,NotificationServiceModule::class])
interface UserRegistrationServiceComponent {

    fun inject(mainActivity: MainActivity)

}