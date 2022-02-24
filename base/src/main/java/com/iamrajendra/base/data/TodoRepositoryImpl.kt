package com.iamrajendra.base.data

import com.iamrajendra.base.pojo.Post
import com.iamrajendra.room.dao.PostDao
import com.iamrajendra.room.model.PostTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    networkService: NetworkService?,
    databaseService: PostDao?
) : TodoRepo {
    lateinit var networkService: NetworkService
    lateinit var databaseService: PostDao

    init {
        if (networkService != null) {
            this.networkService = networkService

        }
        if (databaseService != null) {
            this.databaseService = databaseService
        }
    }

    override fun fetchFromRemote(): Flow<Response> = flow<Response> {
        emit(Response.Loading)
        var service = networkService.makeTodoService()
        val response = service.getAll()
        if (response.isSuccessful) {
            var list = response.body()
            var newlist = list?.map {
                PostTable(
                    uid = it.id!!,
                    id = it.id,
                    userId = it.userId,
                    title = it.title,
                    completed = it.completed
                )
            }
            newlist?.forEach {
                databaseService.insertAll(it)


            }

            emit(Response.Successful(response.body()!!))
        }
    }.flowOn(Dispatchers.IO)

    override fun fetchFromDatabase(): Flow<Response> = flow {
        emit(Response.Loading)
       var convertetList = listOf<Post>()
        suspend {
            var list = databaseService.getAll()
             convertetList = list.map {
                Post(userId = it.userId, id = it.id, title = it.title, completed = it.completed)
            }
        }
        emit(Response.Successful(convertetList))
    }.flowOn(Dispatchers.IO)


}