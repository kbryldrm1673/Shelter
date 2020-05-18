package com.kubra.koubitirme.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kubra.koubitirme.Models.User


@Dao
interface UserDAO {

    @Query("SELECT * FROM userInfo where user_email= :mail and user_password= :password")
    fun getUser(mail: String, password: String):LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User?):String

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)
}