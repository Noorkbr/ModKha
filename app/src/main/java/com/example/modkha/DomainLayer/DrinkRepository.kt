package com.example.modkha.DomainLayer

import com.example.modkha.DataLayer.ResponseDrinkDto
import retrofit2.Response

interface DrinkRepository {
    suspend fun getDrinkList(drinkName: String): Response<ResponseDrinkDto>
}