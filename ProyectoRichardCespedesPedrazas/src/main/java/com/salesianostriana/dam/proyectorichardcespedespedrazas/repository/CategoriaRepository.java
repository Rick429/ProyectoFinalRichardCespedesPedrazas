package com.salesianostriana.dam.proyectorichardcespedespedrazas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

	Categoria findFirstByNombre(String nombre);
}
