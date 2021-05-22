package com.salesianostriana.dam.proyectorichardcespedespedrazas.service.base;

import java.util.List;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.repository.JuegoRepository;

@Service
/**
 * 
 * @author RichardCespedes
 *
 */
public class JuegoService extends BaseService<Juego, Long, JuegoRepository>{

	/**
	 * 
	 * @param a nombre del juego
	 * @return Devuelve un juego si el nombre es igual al proporcionado
	 */
	public List<Juego> buscarPorNombre(String a) {
		return this.repositorio.findByNombreContainsOrderByNombreAsc(a);
	}
	
	/**
	 * @param id id del juego
	 * @return Devuelve una lista de juegos ordenada por nombre si la disponibilidad es true
	 */
	public List<Juego> todosLosJuegosDeUnaCategoria(Long id) {
		return this.repositorio.findByCategoriaIdCategoriaAndDisponibilidadTrueOrderByNombreAsc(id);
	}
	
	/**
	 * 
	 *@return Devuelve los ultimos 5 juegos agregados ordenados por fecha de alta
	 */
	public List<Juego>juegosNuevos(){
		return this.repositorio.findTop5ByOrderByFechaAltaDesc();
	}
	

	

}