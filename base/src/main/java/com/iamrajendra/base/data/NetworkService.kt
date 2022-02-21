package com.iamrajendra.base.data

import com.iamrajendra.base.api.Todos
import dagger.Module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkService {


    fun makeTodoService(): Todos {
        return Retrofit.Builder()
            .baseUrl(Todos.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Todos::class.java)
    }
}