package com.example.daggerlearning.service.registerationservice

import com.example.daggerlearning.service.notificationservice.NotificationService
import com.example.daggerlearning.service.notificationservice.PhoneNotificationServiceQualifier
import com.example.daggerlearning.service.userrepository.UserRepository
import javax.inject.Inject

class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @PhoneNotificationServiceQualifier private val notificationService: NotificationService,
) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "no-reply@rahulgothwal5.com", "User Registered")
    }
}