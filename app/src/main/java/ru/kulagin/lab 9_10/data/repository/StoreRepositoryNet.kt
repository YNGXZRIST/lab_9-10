package ru.kulagin.lab9_10.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.kulagin.lab9_10.data.network.AppNetwork
import ru.kulagin.lab9_10.data.network.model.CakeDetailNet
import ru.kulagin.lab9_10.domain.model.Cake
import ru.kulagin.lab9_10.domain.model.CakeDetail

class StoreRepositoryNet(
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    private val cakesService = AppNetwork.cakesService

    suspend fun cakesList(): List<Cake> = withContext(defaultDispatcher){
        val response = cakesService.getCakes()
        val cakeList = if(response.isSuccessful){
            response.body()?.cake_list ?: listOf()
        } else listOf()

        cakeList.map{
            with(it){ Cake(id, name, calories?.toDouble(), image, price?.toDouble(), weight?.toDouble()) }
        }
    }

    suspend fun cake(id: Long): CakeDetail = withContext(defaultDispatcher){
        val response = cakesService.getCake(id)
        val cake = if(response.isSuccessful){
            response.body() ?: CakeDetailNet.emptyCakeDetailNet()
        } else CakeDetailNet.emptyCakeDetailNet()
        var cakeDetail: CakeDetail
        cake.apply {
            cakeDetail = CakeDetail(id, name, calories?.toDouble(), image, price?.toDouble(), weight?.toDouble(), description, composition)
        }
        cakeDetail
    }
}