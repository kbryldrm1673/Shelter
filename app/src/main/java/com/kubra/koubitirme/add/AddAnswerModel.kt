package com.kubra.koubitirme.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kubra.koubitirme.models.Question

class AddAnswerModel(application: Application): AndroidViewModel(application) {

    private val repository: AddAnswerRepository by lazy { AddAnswerRepository(application) }

    fun insert(question: Question) = repository.insertQuestion(question)


}