package com.kubra.koubitirme.design.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kubra.koubitirme.animalModel.Example
import com.kubra.koubitirme.design.main.MainRepository

class ImageListViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }

    fun getAnimalImage(): LiveData<List<Example>>? = repository.getAnimalImage()

}