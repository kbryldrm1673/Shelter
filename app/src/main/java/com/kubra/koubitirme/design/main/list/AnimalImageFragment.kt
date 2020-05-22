package com.kubra.koubitirme.design.main.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import com.kubra.koubitirme.R
import com.kubra.koubitirme.animalModel.Example
import com.kubra.koubitirme.common.BaseViewModelFragment
import com.kubra.koubitirme.data.remote.ApiClient
import com.kubra.koubitirme.data.remote.ApiService
import com.kubra.koubitirme.design.main.AnimalAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnimalImageFragment : BaseViewModelFragment<ImageListViewModel>() {

    private lateinit var adapter: AnimalAdapter

    override fun getViewModel(): Class<ImageListViewModel> = ImageListViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getAnimalImage()
        return inflater.inflate(R.layout.fragment_animal_image, container, false)
    }

}


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


/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        adapter=AnimalAdapter()
        list_recyclerView.layoutManager= GridLayoutManager(activity,2)

        val observe = viewModel.getAnimalImage()?.observe(this, Observer {animals->
            animals?.let {
                adapter.submitList(it)
            }
        })
        list_recyclerView.adapter=adapter
            list_recyclerView.visible()
            list_recyclerView.gone()



        }
    }*/








