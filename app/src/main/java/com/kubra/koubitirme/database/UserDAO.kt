package com.kubra.koubitirme.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kubra.koubitirme.models.User


@Dao
interface UserDAO {

    @Query("SELECT * FROM userInfo WHERE user_email= :mail and user_password= :password")
    fun getUser(mail: String, password: String):LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User?):Long

    @Update
    fun update(user: User?)

    @Delete
    fun delete(user: User?)


}