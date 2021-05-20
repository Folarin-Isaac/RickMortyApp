package com.example.rickmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickmortyapp.ApiPaging
import com.example.rickmortyapp.api.ApiClient
import com.example.rickmortyapp.api.RetrofitClass

class MainActivityViewModel: ViewModel(){
    val service: ApiClient = RetrofitClass.getRetrofit()
        .create(ApiClient::class.java)

    val characters = Pager(PagingConfig(pageSize = 20)){
        ApiPaging(service)
    }.flow.cachedIn(viewModelScope)

    fun getCharacters(){

    }

}