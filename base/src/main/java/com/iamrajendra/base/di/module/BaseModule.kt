package com.iamrajendra.base.di.module

import android.content.Context
import androidx.room.Room
import com.iamrajendra.base.data.*
import com.iamrajendra.room.dao.AppDatabase
import com.iamrajendra.room.dao.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule {

 @Provides
 @Singleton
 fun provideDatabaseService() = DatabaseService()

 @Provides
 @Singleton
 fun provideNetworkService() = NetworkService()

 @Provides
 @Singleton
 fun provideRout() = Rout()

 @Provides
 @Singleton
 fun provideTodoRepository(networkService: NetworkService, databaseService:PostDao):TodoRepo{

  return TodoRepositoryImpl(networkService,databaseService)
}
}