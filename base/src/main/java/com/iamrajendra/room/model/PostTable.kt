package com.iamrajendra.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostTable(
    @PrimaryKey val uid: Int =0,
    @ColumnInfo(name = "userId") val userId: Int?=1,
    @ColumnInfo(name = "id") val id: Int?=1,
    @ColumnInfo(name = "title") val title: String?="",
    @ColumnInfo(name = "completed") val completed: Boolean?=false)