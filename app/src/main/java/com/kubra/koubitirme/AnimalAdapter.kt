package com.kubra.koubitirme

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kubra.koubitirme.animalModel.Animal

class AnimalAdapter(val context: Context) : RecyclerView.Adapter<AnimalAdapter.MyViewHolder>() {

    var animalList : List<Animal> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_image_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text = animalList[position].ismi
        /*
        Glide.with(context).load(animalList.get(position).resmi)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)*/
    }

    fun setMovieListItems(movieList: List<Animal>){
        this.animalList = animalList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val name: TextView = itemView!!.findViewById(R.id.itemTextView)
       // val image: ImageView = itemView!!.findViewById(R.id.image)

    }
}