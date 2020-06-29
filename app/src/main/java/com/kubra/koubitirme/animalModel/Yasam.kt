package com.kubra.koubitirme.animalModel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Yasam(

    @SerializedName("evbahce")
    val evbahce: Boolean,

    @SerializedName("sahipmi")
    val sahipmi: Boolean,

    @SerializedName("istenentur")
    val istenentur: String,

    @SerializedName("engelli")
    val engelli: Boolean,

    @SerializedName("tecrube")
    val tecrube: Boolean,

    @SerializedName("aciklama")
    val aciklama: String

): Serializable