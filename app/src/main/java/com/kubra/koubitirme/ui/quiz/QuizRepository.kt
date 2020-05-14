package com.kubra.koubitirme.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import com.kubra.koubitirme.data.QuestionDAO
import com.kubra.koubitirme.data.QuestionDatabase
import com.kubra.koubitirme.model.Question

class QuizRepository(context: Context) {
    private val db by lazy { QuestionDatabase.getInstance(context) }
    private val dao: QuestionDAO by lazy { db.questionDao() }

    fun getAllQuestions(): LiveData<List<Question>> =
        dao.getQuestions()
}
