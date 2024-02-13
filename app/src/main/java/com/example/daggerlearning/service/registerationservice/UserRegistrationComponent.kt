package com.example.daggerlearning.service.registerationservice

import com.example.daggerlearning.AppComponent
import com.example.daggerlearning.MainActivity
import com.example.daggerlearning.service.analyticsService.AnalyticsServiceModule
import com.example.daggerlearning.service.di.ActivityScope
import com.example.daggerlearning.service.notificationservice.NotificationServiceModule
import com.example.daggerlearning.service.userrepository.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
@Subcomponent(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationServiceComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserRegistrationServiceComponent
        fun retryCount(@BindsInstance retryCount: Int): Builder
    }
}