package com.kubra.koubitirme.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class User(

    @PrimaryKey(autoGenerate = true)
    var userid: Int ?=null,

    @ColumnInfo(name="user_name")
    var name: String?=null,

    @ColumnInfo(name="user_lastName")
    var lastName: String?=null,

    @ColumnInfo(name="user_email")
    var email: String?=null,

    @ColumnInfo(name="user_password")
    var password: String?=null




) {
    constructor(name: String?,lastName: String?,email: String?,password: String?):this()
}