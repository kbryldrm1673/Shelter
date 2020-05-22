package com.kubra.koubitirme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.animal_detail_item.view.*

class AnimalAdapter(val animalList:ArrayList<Animal>):RecyclerView.Adapter<AnimalAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_detail_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return animalList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.textView1.text=animalList[position].name
    }

    fun updateAnimalList( newAnimalList : ArrayList<Animal>){
        animalList.clear()
        newAnimalList.addAll(newAnimalList)
        notifyDataSetChanged()
    }


}

