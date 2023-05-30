package com.example.parcialtp3.apiServiceBuilder

import com.example.parcialtp3.model.Car
import com.example.parcialtp3.model.CarResponse
import retrofit2.Call
import retrofit2.http.GET

interface CarService {

    @GET("cars?limit=3&transmission=a&year=2022&fuel_type=gas")
    fun getCarsList(): Call<List<Car>>
}