package com.iamrajendra.base.di.module

import com.iamrajendra.base.data.DatabaseService
import com.iamrajendra.base.data.NetworkService
import com.iamrajendra.base.data.Rout
import com.iamrajendra.base.data.TodoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule {

@Provides
@Singleton
fun  provideDatabaseService()  = DatabaseService()

 @Provides
 @Singleton
 fun provideNetworkService() = NetworkService()
 @Provides
 @Singleton
 fun provideRout()  = Rout()
 @Provides
 @Singleton
 fun provideTodoRepository () = TodoRepository(NetworkService(),DatabaseService(),)
}