package com.ammar.jakartapost.di

import com.ammar.jakartapost.BuildConfig.END_POINT
import com.ammar.jakartapost.data.model.News
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    suspend fun getNews() : Response<News>
}