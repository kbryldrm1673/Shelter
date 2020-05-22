package com.kubra.koubitirme.animalModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "animal")
data class AnimalBreeds(

    @PrimaryKey
    @SerializedName("id")
    var breedId: Int,

    @SerializedName("bred_for")
    var breedFor:String?,

    @SerializedName("breed_group")
    var breedGroup : String?,

    @SerializedName("life_span")
    var lifeSpan : String?,

    @SerializedName("name")
    var name : String?,

    @SerializedName("origin")
    var origin : String?,

    @SerializedName("temperament")
    var temperament:String?

    )
