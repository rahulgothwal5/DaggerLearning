package com.example.daggerlearning

import com.example.daggerlearning.service.analyticsService.AnalyticsService
import com.example.daggerlearning.service.analyticsService.AnalyticsServiceModule
import com.example.daggerlearning.service.registerationservice.UserRegistrationServiceComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsServiceModule::class])
interface AppComponent {

    fun getUserRegistrationServiceComponentFactory() : UserRegistrationServiceComponent.Factory

}