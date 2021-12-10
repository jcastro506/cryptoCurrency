package com.example.cryptocurrencies.domain.use_case.get_coin

import com.example.cryptocurrencies.common.Resource
import com.example.cryptocurrencies.data.remote.dto.toCoinDetail
import com.example.cryptocurrencies.domain.models.Coin
import com.example.cryptocurrencies.domain.models.CoinDetail
import com.example.cryptocurrencies.domain.models.toCoin
import com.example.cryptocurrencies.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try {
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e:HttpException) {

        } catch (e:IOException){

        }
    }

}