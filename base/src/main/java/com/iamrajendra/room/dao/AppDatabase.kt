package com.iamrajendra.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iamrajendra.room.model.PostTable

@Database(entities = [PostTable::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao


}