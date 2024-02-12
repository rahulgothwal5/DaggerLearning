package com.example.daggerlearning.service

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(sqlUserRepository: SqlUserRepository): UserRepository
}