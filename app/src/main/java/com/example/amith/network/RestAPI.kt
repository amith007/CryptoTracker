package com.example.amith.network

import com.example.amith.cryptorate.CoinListResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPI {
    private val coinListService:CoinListService
    init {
        val httpClient = OkHttpClient().newBuilder()
        val interceptor = Interceptor { chain ->
            val request = chain?.request()?.newBuilder()?.addHeader("Content-Type", "application/json")?.build()
            chain?.proceed(request)
        }
        httpClient.networkInterceptors().add(interceptor)

//            val httpLoggingInterceptor = HttpLoggingInterceptor()
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            httpClient.addInterceptor(httpLoggingInterceptor)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
         coinListService = retrofit.create(CoinListService::class.java)
    }

    fun getTokenList(): Call<CoinListResponse> {
        return coinListService.getTokeList()
    }

}