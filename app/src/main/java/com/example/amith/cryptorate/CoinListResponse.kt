package com.example.amith.cryptorate

import com.google.gson.annotations.SerializedName

data class CoinListResponse(
        @SerializedName("data") val data: List<CoinData>
)

data class CoinData(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("symbol") val symbol: String,
        @SerializedName("website_slug") val websiteSlug: String
)