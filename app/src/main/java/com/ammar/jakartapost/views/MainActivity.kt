package com.ammar.jakartapost.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ammar.jakartapost.R
import com.ammar.jakartapost.data.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var vm: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}