package com.example.amith.cryptorate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.example.amith.network.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity(), Callback<CoinListResponse> {
    private var coinListData: List<CoinData>? = null
    private lateinit var cryptoListRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cryptoListRecycler = findViewById(R.id.cryptolist_recycler)
        cryptoListRecycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        RestAPI().getTokenList().enqueue(this)
    }

    override fun onResponse(call: Call<CoinListResponse>?, response: Response<CoinListResponse>?) {
        if (response != null && response?.isSuccessful && response?.body() != null) {
            coinListData = response?.body()!!.data
            cryptoListRecycler.adapter = CryptoListAdapter(coinListData!!)
        }
    }

    override fun onFailure(call: Call<CoinListResponse>?, t: Throwable?) {
        Log.e("retrofit", "Coin list call failed ${t?.message}")
    }

}
