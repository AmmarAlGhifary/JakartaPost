package com.ammar.jakartapost.repository

import com.ammar.jakartapost.di.ApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getNews() = apiService.getNews()
}