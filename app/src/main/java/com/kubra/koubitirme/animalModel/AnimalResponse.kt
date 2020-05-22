package com.kubra.koubitirme.animalModel

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class AnimalResponse(

    @PrimaryKey
    @SerializedName("id")
    var animalId: String,

    @SerializedName("breeds")
    var results:List<AnimalBreeds>,

    @SerializedName("height")
    var height : Int?,

    @SerializedName("url")
    var url: String?

)