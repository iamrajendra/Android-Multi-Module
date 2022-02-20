package com.iamrajendra.base.di.module

import com.iamrajendra.base.data.DatabaseService
import com.iamrajendra.base.data.NetworkService
import com.iamrajendra.base.data.Rout
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
}