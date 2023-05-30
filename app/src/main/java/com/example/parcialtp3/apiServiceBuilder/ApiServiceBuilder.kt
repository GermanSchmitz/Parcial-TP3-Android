package com.example.parcialtp3.apiServiceBuilder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceBuilder {
    private val BASE_URL = "https://api.api-ninjas.com/v1/"
    private val API_KEY = "RkJx8ABXTg4UH0X5tMCrO7sovVYqUsdnaGcohpa7"

    private val retrofit: Retrofit = run {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val newRequest = originalRequest.newBuilder()
                    .header("X-Api-Key", API_KEY)
                    .build()
                chain.proceed(newRequest)
            }
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun create(): CarService {
        return retrofit.create(CarService::class.java)
    }

}