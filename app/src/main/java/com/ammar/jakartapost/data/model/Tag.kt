package com.ammar.jakartapost.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tag(
    val id: Int,
    val link: String,
    val name: String
) : Parcelable