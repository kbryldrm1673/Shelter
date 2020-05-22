package com.kubra.koubitirme.design.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kubra.koubitirme.animalModel.Example
import com.kubra.koubitirme.data.remote.ApiClient
import com.kubra.koubitirme.data.remote.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    private val apiService: ApiService by lazy { ApiClient.getApiService() }


    fun getAnimalImage(): MutableLiveData<List<Example>> {
        val animalLiveData: MutableLiveData<List<Example>> = MutableLiveData()
        apiService.getAnimalBreed().enqueue(object : Callback<Example> {
            override fun onFailure(call: Call<Example>, t: Throwable) {
                Log.e("aaa", t.message)
            }

            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                //  animalLiveData.value = response.body().get()
                var enes = "a";
            }

        })

        return animalLiveData

    }
}



