package com.ammar.jakartapost.views.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ammar.jakartapost.R
import com.ammar.jakartapost.data.viewmodel.NewsViewModel
import com.ammar.jakartapost.databinding.FragmentHomeBinding
import com.ammar.jakartapost.views.MainActivity
import com.ammar.jakartapost.views.home.adapter.HomeAdapter
import com.ammar.jakartapost.util.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    @FragmentScoped
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: HomeAdapter
    private val viewModel: NewsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRv()

    }

    private fun setUpRv() {
        homeAdapter = HomeAdapter()
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
            adapter = homeAdapter
        }
        viewModel.newsResponse.observe(requireActivity(), { result ->
                homeAdapter.dataNews = result.data
            })

    }
}