package com.example.parcialtp3.entities

class MarcaRepository() {
    var marcas : MutableList<Marca> = mutableListOf()

    init{
        marcas.add(Marca("Toyota", "50"))
        marcas.add(Marca("Ford", "25"))
        marcas.add(Marca("Chevrolet", "10"))
        marcas.add(Marca("Honda", "35"))
        marcas.add(Marca("Volkswagen", "60"))
        marcas.add(Marca("BMW", "15"))
        marcas.add(Marca("Mercedes-Benz", "42"))
        marcas.add(Marca("Audi", "18"))
        marcas.add(Marca("Hyundai", "30"))
        marcas.add(Marca("Nissan", "55"))
    }
}