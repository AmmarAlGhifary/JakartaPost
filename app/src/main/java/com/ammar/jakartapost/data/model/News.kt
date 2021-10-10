package com.ammar.jakartapost.data.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val data : List<Data>,
    val newsResponse: NewsResponse
) : Parcelable