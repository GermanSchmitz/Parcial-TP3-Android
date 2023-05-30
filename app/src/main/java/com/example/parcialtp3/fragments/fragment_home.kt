package com.example.parcialtp3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.parcialtp3.R
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.adapters.CarAdapter
import com.example.parcialtp3.adapters.MarcaAdapter
import com.example.parcialtp3.entities.MarcaRepository

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_home.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var vista : View
    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var text3: TextView

    private lateinit var carAdapter: CarAdapter
    private lateinit var carViewModel: CarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista = inflater.inflate(R.layout.fragment_prueba1, container, false)
        text1 = vista.findViewById(R.id.text1)
        text2 = vista.findViewById(R.id.text2)
        text3 = vista.findViewById(R.id.text3)

        text1.setOnClickListener {
            //val action = fragment_home.Directions.actionItemHomeToItemAutos()
            findNavController().navigate(R.id.item_autos)
        }

        text2.setOnClickListener {
            //val action = fragment_homeDirections.action_item_home_to_item_autos()
            findNavController().navigate(R.id.item_autos)
        }

        text3.setOnClickListener {
            //val action = fragment_homeDirections.action_item_home_to_item_autos()
            findNavController().navigate(R.id.item_autos)
        }

        // Configurar el RecyclerView y el adaptador
        val recyclerView: RecyclerView = vista.findViewById(R.id.carRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        carAdapter = CarAdapter(emptyList())
        recyclerView.adapter = carAdapter

        return vista
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment prueba1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}