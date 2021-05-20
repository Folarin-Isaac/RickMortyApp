package com.example.rickmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickmortyapp.models.Result
import com.example.rickmortyapp.databinding.CharacterItemListBinding

class CharacterAdapter(val context: Context) :
    PagingDataAdapter<Result, CharacterAdapter.CharacterViewHolder>(CharacterComparator) {

    class CharacterViewHolder(val binding: CharacterItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, character: Result) {
            Glide.with(context)
                .load(character.image!!)
                .into(binding.image)
            binding.name.text = character.names
        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(context, getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding: CharacterItemListBinding = CharacterItemListBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    object CharacterComparator : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.names == newItem.names

        }
    }
}