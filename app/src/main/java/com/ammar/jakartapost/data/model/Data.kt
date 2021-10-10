package com.ammar.jakartapost.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val channels: Channels,
    val gallery: List<Gallery>,
    val id: String,
    val isLongform: Boolean,
    val isPremium: Boolean,
    val line: String,
    val location: String,
    val path: String,
    val publishedDate: String,
    val sourceId: Int,
    val summary: String,
    val tags: List<Tag>,
    val title: String,
    val writer: Writer

) : Parcelable