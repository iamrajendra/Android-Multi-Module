package com.iamrajendra.base.pojo

import com.google.gson.annotations.SerializedName

data class Post (

    @SerializedName("userId"    ) var userId    : Int?     = null,
    @SerializedName("id"        ) var id        : Int?     = null,
    @SerializedName("title"     ) var title     : String?  = null,
    @SerializedName("completed" ) var completed : Boolean? = null

)