package com.example.rickmortyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickmortyapp.adapter.CharacterAdapter
import com.example.rickmortyapp.databinding.ActivityMainBinding
import com.example.rickmortyapp.viewmodel.MainActivityViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val context = this
        val pagingAdapter = CharacterAdapter(context)
        binding.characterListRV.let {
            it.adapter = pagingAdapter
            it.layoutManager = GridLayoutManager(context,2)
            it.setHasFixedSize(true)
        }

        lifecycleScope.launch {
            viewModel.characters.collectLatest { pagedData ->
                pagingAdapter.submitData(pagedData)
            }
        }
    }

}