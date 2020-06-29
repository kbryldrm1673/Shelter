package com.kubra.koubitirme.animalModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Animal(
    @SerializedName("cinsi")
    val cinsi: Int,

    @SerializedName("egitimlimi")
    val egitimlimi: Boolean,

    @SerializedName("id")
    val id: Int,

    @SerializedName( "ismi")
    val ismi: String,

    @SerializedName("resmi")
    val resmi: String,

    @SerializedName( "uysalmi")
    val uysalmi: Boolean,

    @SerializedName("yas")
    val yas: Int
):Serializable




