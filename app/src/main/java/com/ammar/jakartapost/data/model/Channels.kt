package com.ammar.jakartapost.data.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Channels(
    val color: String,
    val id: Int,
    val name: String,
    val parent: String
) : Parcelable