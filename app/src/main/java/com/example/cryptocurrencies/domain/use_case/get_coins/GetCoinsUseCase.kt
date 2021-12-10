package com.example.cryptocurrencies.domain.use_case.get_coins

import com.example.cryptocurrencies.common.Resource
import com.example.cryptocurrencies.domain.models.Coin
import com.example.cryptocurrencies.domain.models.toCoin
import com.example.cryptocurrencies.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e:HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e:IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check internet connection."))
        }
    }

}