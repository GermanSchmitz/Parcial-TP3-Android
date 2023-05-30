package com.example.parcialtp3.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Marca (
    var nombre : String,
    var cantidad : String,
) : Parcelable {
}