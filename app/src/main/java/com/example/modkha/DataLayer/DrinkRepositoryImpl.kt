package com.example.modkha.DataLayer


import com.example.modkha.DomainLayer.DrinkRepository
import retrofit2.Response
import javax.inject.Inject

class DrinkRepositoryImpl @Inject constructor(
    private val apiService: DrinkApiService

):DrinkRepository {
    override suspend fun getDrinkList(drinkName: String): Response<ResponseDrinkDto> {
        val response = apiService.getRandomDrink(drinkName)
        return response
    }


}