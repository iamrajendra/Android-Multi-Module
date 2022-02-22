package com.iamrajendra.base.data

import android.util.Log
import com.iamrajendra.base.realm.scheme.PostRealm
import com.iamrajendra.base.utils.InjectUtils
import com.iamrajendra.base.utils.RxBus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

class TodoRepository(networkService: NetworkService?, databaseService: DatabaseService?){
     lateinit var  networkService: NetworkService
     lateinit var databaseService: DatabaseService
     var  bus   =RxBus<Response>()
    init {
        if (networkService != null) {
            this.networkService  = networkService

        }
        if (databaseService != null) {
            this.databaseService = databaseService
        }
    }



    fun  fetchFromRemote(){
        val service = networkService.makeTodoService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getAll()
            try {
            if (response.isSuccessful) {
                var list = databaseService.todoDao().convertFromPostPojoList(response.body()!!)
                databaseService.todoDao().insertAll(list)
            var localList =    fetchFromLocal()
                var successfull =Response.Successful(localList)
                bus.send(successfull)

            }else {
                var error  = Response.Failure(message = "Error code is ${response.code()}" )
                bus.send(error)

            }
            }catch (e:Exception){
                var error  = Response.Failure(e,"Error code is ${response.code()}" )
                bus.send(error)

            }
        }

    }


    fun fetchFromLocal():List<PostRealm>{
    return  listOf()
    }
}