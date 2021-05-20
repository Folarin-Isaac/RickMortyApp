package com.example.rickmortyapp.models

import com.google.gson.annotations.SerializedName

class ApiResponse {
    @SerializedName("info")
    lateinit var info:Info

    @SerializedName("results")
    lateinit var  results:List<Result>

}