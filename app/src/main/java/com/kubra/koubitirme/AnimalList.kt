package com.kubra.koubitirme

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kubra.koubitirme.animalModel.Animal
import kotlinx.android.synthetic.main.activity_animal_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class AnimalList : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        getImage()



    }

    private fun getImage(){
        val value:Any = RetrofitClient.getClient().create(ApiService::class.java).getInfo().enqueue(object : Callback<List<Animal>> {
            override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                showData(response.body()!!)
                /*for(i in response.body()!!.indices){
                    Log.d("onResponse","${response.body()?.get(i)}")
                }*/
                 }
            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                Toast.makeText(this@AnimalList,"Failure", Toast.LENGTH_LONG).show()
                Log.e("onFailure","${t.message}")
            }
        })
    }

    private fun showData(animal: List<Animal>) {
        reyclerViewList.apply {
            layoutManager=GridLayoutManager(applicationContext,2,LinearLayoutManager.VERTICAL,false)
            adapter = AnimalAdapter(animal)



        }
    }

}






