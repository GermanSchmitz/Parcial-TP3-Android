package com.example.parcialtp3.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.parcialtp3.apiServiceBuilder.ApiServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import androidx.lifecycle.MutableLiveData
import com.example.parcialtp3.apiServiceBuilder.CarService
import com.example.parcialtp3.model.Car
import retrofit2.Response

class CarViewModel : ViewModel() {
    private val carService: CarService = ApiServiceBuilder.create()

    private val _carList: MutableLiveData<List<Car>?> = MutableLiveData()
    val carList: LiveData<List<Car>?> get() = _carList

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    // Método para obtener la lista de autos desde el servicio
    fun fetchCars() {
        carService.getCarsList().enqueue(object : Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                if (response.isSuccessful) {
                    val carList: List<Car>? = response.body()
                    _carList.value = carList
                } else {
                    _error.value = "Error obteniendo la información: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                _error.value = "Error: ${t.message}"
                Log.d("TAG", "Error: ${t.message}")
            }
        })
    }
}





