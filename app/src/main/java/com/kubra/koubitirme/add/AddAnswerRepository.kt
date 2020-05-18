package com.kubra.koubitirme.add

import android.content.Context
import android.os.AsyncTask
import com.kubra.koubitirme.Database.QuestionDAO
import com.kubra.koubitirme.Database.QuestionDatabase
import com.kubra.koubitirme.Models.Question

class AddAnswerRepository(context: Context) {
    private val db:QuestionDatabase by lazy { QuestionDatabase.getInstance(context) }
    private val dao: QuestionDAO by lazy { db.questionDao() }

    fun insertQuestion(question: Question) {
        InsertAsyncTask(dao).execute(question)
    }

    private class InsertAsyncTask(val dao: QuestionDAO) :
        AsyncTask<Question, Void, Void>() {
        override fun doInBackground(vararg params: Question?): Void? {
            dao.addQuestion(params[0]!!)
            return null
        }


    }
}