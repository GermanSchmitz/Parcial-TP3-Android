package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.model.Car

class CarAdapter(private var carList: List<Car>) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    // Método llamado cuando se crea una nueva vista de elemento de la lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return CarViewHolder(itemView)
    }

    // Método llamado cuando se vincula un elemento de la lista con una vista
    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentCar = carList[position]
        holder.bind(currentCar)
    }

    //Actualiza la lista de autos y notifica los cambios al adaptador.
    fun updateData(newCarList: List<Car>) {
        carList = newCarList
        notifyDataSetChanged()
    }

    // Método que devuelve la cantidad de elementos en la lista
    override fun getItemCount(): Int {
        return carList.size
    }

    // Clase interna que define el ViewHolder para cada elemento de la lista
    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val makeTextView: TextView = itemView.findViewById(R.id.makeTextView)
        private val modelTextView: TextView = itemView.findViewById(R.id.modelTextView)
        private val yearTextView: TextView = itemView.findViewById(R.id.yearTextView)
        private val classTextView: TextView = itemView.findViewById(R.id.classTextView)
        private val fuelTypeTextView: TextView = itemView.findViewById(R.id.fuelTypeTextView)
        private val transmissionTextView: TextView = itemView.findViewById(R.id.transmissionTextView)

        // Método para vincular los datos de un objeto Car con las vistas correspondientes
        fun bind(car: Car) {
            makeTextView.text = car.make
            modelTextView.text = car.model
            yearTextView.text = car.year.toString()
            classTextView.text = car.carClass
            fuelTypeTextView.text = car.fuel_type
            transmissionTextView.text = car.transmission
        }
    }
}