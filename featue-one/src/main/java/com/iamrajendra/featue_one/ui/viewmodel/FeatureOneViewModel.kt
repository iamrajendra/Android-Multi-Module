package com.iamrajendra.featue_one.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamrajendra.base.data.Response
import com.iamrajendra.base.data.TodoRepo
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FeatureOneViewModel @Inject constructor( todoRepo: TodoRepo): ViewModel() {
    var  todoRepo  = todoRepo
    private val _live = MutableLiveData<Response>()
    val live: LiveData<Response>
        get() {
            return _live
        }


    fun fetchPost(){
    viewModelScope.launch {
        todoRepo.fetchFromDatabase().collect {
_live.value = it;
        }
    }
}
}