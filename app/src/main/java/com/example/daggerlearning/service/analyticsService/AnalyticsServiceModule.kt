package com.example.daggerlearning.service.analyticsService

import dagger.Module
import dagger.Provides

@Module
class AnalyticsServiceModule {

    @Provides
    fun getAnalyticsService(): AnalyticsService {
        return Mixpanel()
    }
}