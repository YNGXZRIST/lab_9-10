package ru.kulagin.lab9_10.data.network.services

import retrofit2.Response
import ru.kulagin.lab9_10.data.network.model.CakeDetailNet
import ru.kulagin.lab9_10.data.network.model.CakesNet

internal class CakesService(
    private val apiService: CakesServiceApi
) {

    suspend fun getCakes(): Response<CakesNet> = apiService.getCakes()
    suspend fun getCake(id: Long): Response<CakeDetailNet> = apiService.getCake(id)
}