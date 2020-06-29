package com.kubra.koubitirme

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.kubra.koubitirme.animalModel.Animal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.animal_list_detail.view.*

class AnimalAdapter(private val animalList: List<Animal>) : RecyclerView.Adapter<AnimalAdapter.MyViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.animal_list_detail,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val animal = animalList[position]


        Picasso.get().load(animal.resmi).into(holder.image)
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,"${animal.ismi}",Toast.LENGTH_LONG).show()


            val intent= Intent(holder.itemView.context,AnimalDetail::class.java)
            intent.putExtra("pass",animal.resmi)
            intent.putExtra("adi",animal.ismi)
            intent.putExtra("egitim",animal.egitimlimi)
            intent.putExtra("uysal",animal.uysalmi)
            intent.putExtra("cinsi",animal.cinsi)
            holder.itemView.context.startActivity(intent)
        }
    }



    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image :ImageView =itemView.animalImage
    }





}