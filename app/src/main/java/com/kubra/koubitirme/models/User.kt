package com.kubra.koubitirme.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class User(

    @PrimaryKey(autoGenerate = true)
    val userid: Int ?=null,

    @ColumnInfo(name="user_name")
    val name: String?=null,

    @ColumnInfo(name="user_lastName")
    val lastName: String?=null,

    @ColumnInfo(name="user_email")
    val email: String?=null,

    @ColumnInfo(name="user_password")
    val password: String?=null

) {
    constructor(name: String?,lastName: String?,email: String?,password: String?):this()
}