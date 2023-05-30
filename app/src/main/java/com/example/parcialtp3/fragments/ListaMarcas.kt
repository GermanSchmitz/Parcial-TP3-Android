package com.example.parcialtp3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.adapters.MarcaAdapter
import com.example.parcialtp3.entities.MarcaRepository

class ListaMarcas : Fragment() {

    lateinit var vista : View
    lateinit var recyclerMarca : RecyclerView
    var repository : MarcaRepository = MarcaRepository()
    lateinit var adapter : MarcaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_list_marca, container, false)
        recyclerMarca = vista.findViewById(R.id.recMovie)
        return vista
    }

    override fun onStart() {
        super.onStart()
        recyclerMarca.layoutManager = LinearLayoutManager(context)
        adapter = MarcaAdapter(repository.marcas){ position ->
            val action = fragment_homeDirections.actionItemHomeToItemAutos()
            //actionListFragmentToDetailFragment(repository.marcas[position])
            findNavController().navigate(action)
        }
        recyclerMarca.adapter = adapter
    }
}