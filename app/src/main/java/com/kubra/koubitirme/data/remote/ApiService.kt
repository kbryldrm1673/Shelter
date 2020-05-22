package com.kubra.koubitirme.data.remote

import com.kubra.koubitirme.animalModel.Example
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/api/v10/barinaklar/all")
    fun getAnimalBreed():Call<Example>




}