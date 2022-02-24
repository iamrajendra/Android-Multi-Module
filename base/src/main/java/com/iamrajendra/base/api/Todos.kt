package com.iamrajendra.base.api

import com.iamrajendra.base.pojo.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path



interface Todos {
    @GET("/todos/{id}")
    suspend fun   getById(@Path("id") id: Int): Response<Post>
    @GET("/todos")
    suspend fun  getAll(): Response<List<Post>>

    companion object{
        val DOMAIN  = "https://jsonplaceholder.typicode.com/"
    }

}