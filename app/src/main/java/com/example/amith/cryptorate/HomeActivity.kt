package com.example.amith.cryptorate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class HomeActivity : AppCompatActivity() {
    private val coinArray = ArrayList<Coin>()
    private lateinit var cryptoListRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupMockCoins()

        cryptoListRecycler = findViewById(R.id.cryptolist_recycler)
        cryptoListRecycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        cryptoListRecycler.adapter = CryptoListAdapter(coinArray)


    }

    fun setupMockCoins() {
        coinArray.add(Coin(1, "Bitcoin", "BTC", "Bitcoin"))
        coinArray.add(Coin(2, "Litecoin", "LTC", "Litecoin"))
        coinArray.add(Coin(3, "Ixcoin", "IXC", "Ixcoin"))
        coinArray.add(Coin(4, "BitCoin", "BTC", "bitcoin"))
        coinArray.add(Coin(5, "Terracoin", "TRC", "Terracoin"))
        coinArray.add(Coin(6, "Peercoin", "PRC", "Peercoin"))
        coinArray.add(Coin(7, "Novacoin", "NVC", "Novacoin"))
        coinArray.add(Coin(8, "BitCoin", "BTC", "BitCoin"))
        coinArray.add(Coin(9, "Feathercoin", "FTC", "Feathercoin"))
        coinArray.add(Coin(10, "BitCoin", "BTC", "bitcoin"))
        coinArray.add(Coin(11, "BitCoin", "BTC", "bitcoin"))
        coinArray.add(Coin(12, "BitCoin", "BTC", "bitcoin"))
    }



}
