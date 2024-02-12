package com.example.daggerlearning.service

import dagger.Module
import dagger.Provides
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Named
import javax.inject.Qualifier

@Module
class NotificationServiceModule {

    @PhoneNotificationServiceQualifier
    @Provides
    fun getPhoneNotificationService(retryCount :Int): NotificationService {
        return PhoneNotificationService(retryCount)
    }

    @EmailNotificationServiceQualifier
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