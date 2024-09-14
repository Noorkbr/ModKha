package com.example.modkha.core.di

import com.example.modkha.DataLayer.DrinkApiService
import com.example.modkha.DataLayer.DrinkRepositoryImpl
import com.example.modkha.DomainLayer.DrinkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkAppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMealApiService(
        retrofit: Retrofit
    ): DrinkApiService {
        return retrofit.create(DrinkApiService::class.java)

    }

    @Provides
    @Singleton
    fun provideRepo(
        apiService: DrinkApiService
    ): DrinkRepository {
        return DrinkRepositoryImpl(apiService)

    }


}