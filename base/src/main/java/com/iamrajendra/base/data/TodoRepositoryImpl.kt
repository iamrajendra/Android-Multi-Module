package com.iamrajendra.base.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(networkService: NetworkService?, databaseService: DatabaseService?):TodoRepo{
     lateinit var  networkService: NetworkService
     lateinit var databaseService: DatabaseService
    init {
        if (networkService != null) {
            this.networkService  = networkService

        }
        if (databaseService != null) {
            this.databaseService = databaseService
        }
    }

override fun  fetchFromRemote(): Flow<Response> = flow<Response> {
    emit(Response.Loading)
    var   service = networkService.makeTodoService()
    val response  = service.getAll()
    if (response.isSuccessful){
   emit(Response.Successful(response.body()!!))
    }
}.flowOn(Dispatchers.IO)



}