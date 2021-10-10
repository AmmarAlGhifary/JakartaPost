package com.ammar.jakartapost.views.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.ammar.jakartapost.R
import com.ammar.jakartapost.data.model.Data
import com.ammar.jakartapost.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding : FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var news : Data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        news = args.news
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            tvTitleDetail.text = news.title
            tvSource.text = news.channels.name
            tvDate.text = news.publishedDate
            tvDesc.text = news.summary
            ivThumbnailDetail.load(news.gallery[0].pathLarge) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }
}