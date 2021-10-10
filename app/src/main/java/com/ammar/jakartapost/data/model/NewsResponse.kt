package com.ammar.jakartapost.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
    val code: Int,
    val text: String
) : Parcelable