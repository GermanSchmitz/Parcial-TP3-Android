package com.example.parcialtp3.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.CarAdapter

class CarListFragment : Fragment() {
    private lateinit var carViewModel: CarViewModel
    private lateinit var carAdapter: CarAdapter

    // Método llamado al crear la vista del fragmento
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_car_list, container, false)

        // Configurar el RecyclerView y el adaptador
        val recyclerView: RecyclerView = view.findViewById(R.id.carRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        carAdapter = CarAdapter(emptyList())
        recyclerView.adapter = carAdapter

        return view
    }

    // Método llamado cuando la vista se ha creado completamente
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el ViewModel
        carViewModel = ViewModelProvider(this)[CarViewModel::class.java]

        // Observar los cambios en la lista de autos y actualizar el adaptador
        carViewModel.carList.observe(viewLifecycleOwner) { cars ->
            carAdapter.updateData(cars ?: emptyList())
        }
        // Obtener los datos de los autos
        fetchData()
    }

    // Método para obtener los datos de los autos
    private fun fetchData() {
        carViewModel.fetchCars()

        // Observar los errores y mostrar un mensaje Toast en caso de error
        carViewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}