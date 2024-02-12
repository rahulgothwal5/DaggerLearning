package com.example.daggerlearning.service

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