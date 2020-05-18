package com.kubra.koubitirme.Database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.kubra.koubitirme.Models.User

@Database(entities = arrayOf(User::class),version = 1,exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    abstract fun getUserDao(): UserDAO?


}