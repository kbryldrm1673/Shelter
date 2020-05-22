package com.kubra.koubitirme.design.main


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kubra.koubitirme.animalModel.AnimalResponse
import com.kubra.koubitirme.databinding.ItemAnimalBinding


class AnimalAdapter : ListAdapter<AnimalResponse,AnimalAdapter.ViewHolder>(DİFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =ViewHolder.create(LayoutInflater.from(parent.context),parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int)  =holder.bind(getItem(position))


    class ViewHolder(val binding:ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object{
            fun create(inflater:LayoutInflater,parent:ViewGroup):ViewHolder{
                val itemAnimalBinding=ItemAnimalBinding.inflate(inflater,parent,false)
                return ViewHolder(itemAnimalBinding)
            }
        }
        fun bind(animalResponse:AnimalResponse){
            binding.animal=animalResponse
            binding.executePendingBindings()

        }

    }

    companion object{
        val DİFF_CALLBACK:DiffUtil.ItemCallback<AnimalResponse> = object :DiffUtil.ItemCallback<AnimalResponse>(){
            override fun areItemsTheSame(oldItem: AnimalResponse, newItem: AnimalResponse): Boolean = oldItem.animalId==newItem.animalId

            override fun areContentsTheSame(oldItem: AnimalResponse, newItem: AnimalResponse): Boolean =oldItem.animalId==newItem.animalId



        }
    }


}