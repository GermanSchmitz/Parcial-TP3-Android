package com.example.parcialtp3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcialtp3.R
import com.example.parcialtp3.entities.Marca

class MarcaAdapter(
    var marcaList : MutableList<Marca>,
    var onClick : (Int) -> Unit
) : RecyclerView.Adapter<MarcaAdapter.MarcaHolder>() {

    class MarcaHolder(vista : View) : RecyclerView.ViewHolder(vista){
        private var vista = vista
        init {
            this.vista = vista
        }
        fun setNombre(nombre : String){
            val txtNombre : TextView = vista.findViewById(R.id.txtNombre)
            txtNombre.text = nombre
        }
        fun setCant(cant : String){
            val txtCantidad : TextView = vista.findViewById(R.id.txtCantidad)
            txtCantidad.text = cant
        }
        fun getCard() : CardView {
            return vista.findViewById(R.id.marcaCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarcaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.marca_item, parent, false)
        return MarcaHolder(view)
    }

    override fun onBindViewHolder(holder: MarcaHolder, position: Int) {
        holder.setNombre(marcaList[position].nombre)
        holder.setCant(marcaList[position].cantidad)
        holder.getCard().setOnClickListener{
            onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return marcaList.size
    }

}