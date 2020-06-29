package com.kubra.koubitirme

import com.kubra.koubitirme.animalModel.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @GET("/api/hayvanlar/")
    fun getInfo():Call<List<Animal>>

    @GET("/api/hayvanlar/durum")
    fun getYasam():Call<List<Yasam>>

    @GET("/api/v10/barinaklar/all")
    fun getAnimalBreed():Call<Example>


    @Headers("Content-Type:application/json")
    @POST("auth_tokens")
    fun signin(@Body info: UserGET): retrofit2.Call<ResponseBody>


    @Headers("Content-Type:application/json")
    @POST("users")
    fun registerUser(
        @Body info: UserPOST
    ): retrofit2.Call<ResponseBody>

}