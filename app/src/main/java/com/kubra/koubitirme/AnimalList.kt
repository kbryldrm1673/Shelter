package com.kubra.koubitirme

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kubra.koubitirme.animalModel.Animal
import kotlinx.android.synthetic.main.activity_animal_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalList : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var animalAdapter: AnimalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        recyclerView = findViewById(R.id.reyclerViewList)
        animalAdapter = AnimalAdapter(this)
        reyclerViewList.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = animalAdapter

        val value:Any = RetrofitClient.getClient().create(ApiService::class.java)
            .getInfo().enqueue(object :Callback<List<Animal>>{
                override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                    Toast.makeText(this@AnimalList,"Failure",Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<List<Animal>>?, response: Response<List<Animal>>?) {
                    if(response?.body()!=null)
                        animalAdapter.setMovieListItems(response.body()!!)
                    Toast.makeText(this@AnimalList,"Success",Toast.LENGTH_LONG).show()
                    Log.e("onResponce","Kubraaa")
                }

            })




        val fab: View = findViewById(R.id.fab1)
        fab.setOnClickListener {
            val intent = Intent(this@AnimalList, AnimalFood::class.java)
            startActivity(intent)
        }


    }
}




