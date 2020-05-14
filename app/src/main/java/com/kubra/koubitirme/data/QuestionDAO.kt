package com.kubra.koubitirme.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kubra.koubitirme.model.Question

@Dao
interface QuestionDAO {

    @Query("SELECT * FROM questions")
    fun getQuestions(): LiveData<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuestion(question: Question)

    @Query("DELETE FROM questions")
    fun deleteAll()

}