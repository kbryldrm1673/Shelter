package com.kubra.koubitirme

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AnimalList : AppCompatActivity(),OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)


    }

    override fun AnimalItemClickListener(animal:Animal){
        Toast.makeText(this,"Item Click",Toast.LENGTH_LONG).show()
    }
}
