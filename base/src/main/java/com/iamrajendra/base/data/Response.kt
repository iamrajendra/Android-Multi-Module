package com.iamrajendra.base.data

import java.lang.Exception

sealed class Response {
    object  Loading:Response()
data class Successful(var data:Any):Response()
data class Failure(var exception: Exception? =null, var message:String =""):Response()
}