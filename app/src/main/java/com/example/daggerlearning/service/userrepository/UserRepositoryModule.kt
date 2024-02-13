package com.example.daggerlearning.service.userrepository

import com.example.daggerlearning.service.di.ActivityScope
import com.example.daggerlearning.service.userrepository.SqlUserRepository
import com.example.daggerlearning.service.userrepository.UserRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {

    @Binds
    @ActivityScope
    abstract fun bindUserRepository(sqlUserRepository: SqlUserRepository): UserRepository
}