package com.iamrajendra.base.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.iamrajendra.room.dao.AppDatabase
import com.iamrajendra.room.dao.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(app: Application) {
    var app  = app


    fun getAppDatabase(): AppDatabase {
        val db = Room.databaseBuilder(
            app,
            AppDatabase::class.java, "multi-module"
        ).build()
        return db
    }
@Provides
    fun providePostDao():PostDao{
        val userDao = getAppDatabase().postDao()
        return userDao

    }







}