package com.kubra.koubitirme.animalModel

class Example : ArrayList<ExampleItem>()

data class ExampleItem(
    val aktifMi: Boolean,
    val boshayvanKapasitesi: Int,
    val createAt: String,
    val create_at: String,
    val hayvanKapasitesi: Int,
    val id: Int,
    val ismi: String,
    val kalanyemMiktari: Int,
    val updateAt: String,
    val update_at: String,
    val userModel: UserModel,
    val yemKapasitesi: Int
)

data class UserModel(
    val adres: String,
    val createAt: String,
    val create_at: String,
    val email: String,
    val enabled: Boolean,
    val firstName: String,
    val id: Int,
    val lastName: String,
    val password: String,
    val phone: String,
    val profil: String,
    val roleEnum: String,
    val tc: String,
    val telefonYedek: String,
    val updateAt: String,
    val update_at: String,
    val userName: String
)