package com.example.hw5_3pixabay

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hw5_3pixabay.databinding.ItemImageBinding

class PixabayAdapter(val list: List<ImageModel>) :
    RecyclerView.Adapter<PixabayAdapter.PixaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixaViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PixaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PixaViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PixaViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.imageView.load(imageModel.largeImageURL)
        }


    }
}