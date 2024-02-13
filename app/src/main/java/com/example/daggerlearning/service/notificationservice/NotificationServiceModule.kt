package com.example.daggerlearning.service.notificationservice

import com.example.daggerlearning.service.di.ActivityScope
import dagger.Module
import dagger.Provides
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Module
class NotificationServiceModule {

    @PhoneNotificationServiceQualifier
    @ActivityScope
    @Provides
    fun getPhoneNotificationService(retryCount :Int): NotificationService {
        return PhoneNotificationService(retryCount)
    }

    @EmailNotificationServiceQualifier
    @ActivityScope
    @Provides
    fun getEmailNotificationService(emailNotificationService: EmailNotificationService): NotificationService {
        return emailNotificationService
    }
}


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class EmailNotificationServiceQualifier()

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class PhoneNotificationServiceQualifier()