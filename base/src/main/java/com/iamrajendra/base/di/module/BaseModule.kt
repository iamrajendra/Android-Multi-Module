package com.iamrajendra.base.di.module

import com.iamrajendra.base.data.*
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

 fun provideTodoRepository(networkService: NetworkService, databaseService:DatabaseService):TodoRepo{

  return TodoRepositoryImpl(networkService,databaseService)
}
}