package com.ammar.jakartapost.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gallery(
    val id: Int,
    val keyword: String,
    val pathLarge: String,
    val pathMedium: String,
    val pathOrigin: String,
    val pathSmall: String,
    val pathThumbnail: String,
    val photographer: String,
    val source: String,
    val title: String

) : Parcelable