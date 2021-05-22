package com.salesianostriana.dam.proyectorichardcespedespedrazas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Categoria;
/**
 * 
 * @author RichardCespedes
 *
 */
public interface CategoriaRepository extends JpaRepository <Categoria, Long> {

	/**
	 * 
	 * @param nombre nombre de la categoria
	 * @return Devuelve la primera categoria ordenada por nombre
	 */
	Categoria findFirstByNombre(String nombre);
}
