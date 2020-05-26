package com.kubra.koubitirme

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.animal_food.*

class AnimalFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animal_food)
        
        var yuva = listOf(
            "�stanbul Hayvan Bar�na��",
            "Ku�adas� Hayvan Kurtarma Derne�i",
            "Bolu Hayvan Bar�na��",
            "�e�me Hayvan Bar�na��",
            "Odunpazar� Hayvan Bar�na��",
            "Do�al Hayvanlar� Koruma Derne�i"
        )

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, yuva)
        yuva_list.adapter = adapter


        yuva_list.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val barinak = parent.getItemAtPosition(position) as String
                Toast.makeText(this@AnimalFood, "$barinak", Toast.LENGTH_LONG).show()
            }
    }
}