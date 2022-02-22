package com.iamrajendra.base.realm

import com.iamrajendra.base.api.Todos
import com.iamrajendra.base.pojo.Post
import com.iamrajendra.base.realm.scheme.PostRealm

class PostDao {

    fun insertAll(postRealmList:List<PostRealm>){


    }
    fun  insert(postRealm: PostRealm){

    }

    fun convertFromPostPojoList(todoPojoList: List<Post>):List<PostRealm>{
     var list: ArrayList<PostRealm>    = ArrayList()
        for (todos in todoPojoList) {
            list.add(convertTodoPojo(todos))
        }
       return list
    }
    private fun convertTodoPojo(post: Post): PostRealm {
        var  postRealm = PostRealm()
        postRealm.localId  = post.id!!
        postRealm.userId = post.userId!!
        postRealm.title = post.title!!
        postRealm.completed  = post.completed!!
        return postRealm
    }
}