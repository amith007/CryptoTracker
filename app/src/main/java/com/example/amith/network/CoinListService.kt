package com.example.amith.network

import com.example.amith.cryptorate.CoinListResponse
import retrofit2.Call
import retrofit2.http.GET

interface CoinListService {
    @GET("listings/")
    fun getTokeList() : Call<CoinListResponse>
}