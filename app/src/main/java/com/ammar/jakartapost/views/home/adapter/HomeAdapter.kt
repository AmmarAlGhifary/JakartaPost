package com.ammar.jakartapost.views.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ammar.jakartapost.R
import com.ammar.jakartapost.data.model.Data
import com.ammar.jakartapost.data.model.Gallery
import com.ammar.jakartapost.databinding.ItemListBinding
import com.ammar.jakartapost.views.home.HomeFragmentDirections
import com.bumptech.glide.Glide

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var dataNews: List<Data>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsItem = dataNews[position]

        holder.binding.apply {
            tvTitle.text = newsItem.title
            tvCirca.text = newsItem.publishedDate
            ivThumbnail.load(newsItem.gallery[0].pathOrigin) {
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener { mView ->
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(newsItem)
                mView.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int = dataNews.size

    inner class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)
}
