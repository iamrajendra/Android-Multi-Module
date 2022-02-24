package com.iamrajendra.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.iamrajendra.base.pojo.Post
import com.iamrajendra.room.model.PostTable

@Dao
interface PostDao {
    fun hello(){
        print("You are using this class")
    }
    @Query("SELECT * FROM posttable")
    fun getAll(): List<PostTable>

    @Query("SELECT * FROM posttable WHERE uid IN (:uid)")
    fun loadAllByIds(uid: IntArray): List<PostTable>
    @Insert
    fun insertAll(vararg postTable: PostTable)

    @Delete
    fun delete(postTable: PostTable)
}