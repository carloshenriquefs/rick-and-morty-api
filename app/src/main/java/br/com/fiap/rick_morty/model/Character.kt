package br.com.fiap.rick_morty.model

import com.google.gson.annotations.SerializedName

data class Character(
    var id: Int = 0,
    @SerializedName("name")
    var characterName: String = "",
    var species: String = "",
    var image: String = "",
    var gender: String = ""
)
