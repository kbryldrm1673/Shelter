package com.kubra.koubitirme

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel(){
    val animals = MutableLiveData<ArrayList<Animal>>()
    val animalError = MutableLiveData<Boolean>()
    val animalLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val animal = Animal(1,"aa","bb","12","selim","cc","12")
        val animal1 = Animal(2,"ba","bb","12","selim","cc","12")
        val animal2 = Animal(3,"ca","bb","12","selim","cc","12")

        val animalList  = arrayListOf<Animal>(animal,animal1,animal2)

        animals.value=animalList
        animalError.value=false
        animalLoading.value=false

    }

}