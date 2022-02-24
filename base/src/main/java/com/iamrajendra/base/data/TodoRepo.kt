package com.iamrajendra.base.data

import kotlinx.coroutines.flow.Flow

interface TodoRepo {
    fun  fetchFromRemote(): Flow<Response>
    fun fetchFromDatabase():Flow<Response>
}