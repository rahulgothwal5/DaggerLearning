package com.example.daggerlearning.service

import dagger.Binds
import dagger.Module

@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun bindUserRepository(sqlUserRepository: SqlUserRepository): UserRepository
}