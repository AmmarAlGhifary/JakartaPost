package com.ammar.jakartapost.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ammar.jakartapost.data.model.News
import com.ammar.jakartapost.data.model.NewsResponse
import com.ammar.jakartapost.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    private val _response = MutableLiveData<News>()
    val newsResponse: LiveData<News>
        get() = _response

    init {
        getNews()
    }

    fun getNews() = viewModelScope.launch {
        repository.getNews().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("response", "error: ${response.code()}")
            }
        }
    }
}