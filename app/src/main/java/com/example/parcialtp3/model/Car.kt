package com.example.parcialtp3.model

import com.google.gson.annotations.SerializedName

//Tipando respuesta de la API
data class Car(
    @SerializedName("class")
    val carClass: String,
    val fuel_type: String,
    val make: String,
    val model: String,
    val transmission: String,
    val year: Int,
    val image: String

    /*val city_mpg: Int,
    @SerializedName("class")
    val carClass: String,
    val combination_mpg: Int,
    val cylinders: Int,
    val displacement: Double,
    val drive: String,
    val fuel_type: String,
    val highway_mpg: Int,
    val make: String,
    val model: String,
    val transmission: String,
    val year: Int

    */

)