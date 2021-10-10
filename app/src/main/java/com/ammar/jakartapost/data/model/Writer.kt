package com.ammar.jakartapost.data.model


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Writer(
    val id: Int,
    val job: String,
    val name: String,
    val pic: String
) : Parcelable