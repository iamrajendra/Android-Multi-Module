package com.iamrajendra.base.di.compoennt

import android.app.Application
import com.iamrajendra.base.data.DatabaseService
import com.iamrajendra.base.data.NetworkService
import com.iamrajendra.base.data.Rout
import com.iamrajendra.base.data.TodoRepo
import com.iamrajendra.base.di.module.BaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BaseModule::class])
interface BaseComponent {
    fun inject(app:Application)
    fun  getNetworkService() :NetworkService
    fun getDatabaseService():DatabaseService
    fun provideTodoRepository():TodoRepo
    fun getRout ():Rout
}