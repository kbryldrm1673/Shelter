package com.kubra.koubitirme.ui.quiz


import android.content.Context
import androidx.lifecycle.LiveData
import com.kubra.koubitirme.database.QuestionDAO
import com.kubra.koubitirme.database.QuestionDatabase
import com.kubra.koubitirme.models.Question

class  QuizRepository(context: Context) {
    private val db by lazy { QuestionDatabase.getInstance(context) }
    private val dao: QuestionDAO by lazy { db.questionDao() }

    fun getAllQuestions():LiveData<List<Question>> =dao.getQuestions()

    }
