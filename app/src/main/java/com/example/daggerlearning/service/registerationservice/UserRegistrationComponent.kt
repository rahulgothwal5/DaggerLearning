package com.example.daggerlearning.service.registerationservice

import com.example.daggerlearning.AppComponent
import com.example.daggerlearning.MainActivity
import com.example.daggerlearning.service.analyticsService.AnalyticsServiceModule
import com.example.daggerlearning.service.di.ActivityScope
import com.example.daggerlearning.service.notificationservice.NotificationServiceModule
import com.example.daggerlearning.service.userrepository.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationServiceComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance retryCount: Int,appComponent: AppComponent): UserRegistrationServiceComponent
    }
}