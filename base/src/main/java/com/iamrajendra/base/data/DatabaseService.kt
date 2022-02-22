package com.iamrajendra.base.data

import com.iamrajendra.base.realm.PostDao
import javax.inject.Singleton

@Singleton
class DatabaseService {


    fun todoDao() :PostDao{

        return  PostDao()
    }

}