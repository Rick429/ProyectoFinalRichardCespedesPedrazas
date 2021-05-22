package com.salesianostriana.dam.proyectorichardcespedespedrazas.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;

/**
 * 
 * @author RichardCespedes
 *
 */
public interface JuegoRepository extends JpaRepository <Juego, Long>{
	
	/**
	 * 
	 * @param nombre nombre de un juego
	 * @return Devuelve un juego si el nombre es igual al proporcionado
	 */
	List<Juego> findByNombreContainsOrderByNombreAsc(String nombre);
	
	/**
	 * 
	 * @param id id de una categoria
	 * @return Devuelve una lista de juegos ordenada por nombre si la disponibilidad es true
	 */
	List<Juego> findByCategoriaIdCategoriaAndDisponibilidadTrueOrderByNombreAsc(Long id);
	
	/**
	 * @return Devuelve los ultimos 5 juegos agregados ordenados por fecha de alta
	 * 
	 */
	List<Juego> findTop5ByOrderByFechaAltaDesc();
	
	
	
}
