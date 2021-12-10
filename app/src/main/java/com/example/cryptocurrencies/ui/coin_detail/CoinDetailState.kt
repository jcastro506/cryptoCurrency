package com.example.cryptocurrencies.ui.coin_detail

import com.example.cryptocurrencies.domain.models.Coin
import com.example.cryptocurrencies.domain.models.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin : CoinDetail? = null,
    val error : String = ""
)
