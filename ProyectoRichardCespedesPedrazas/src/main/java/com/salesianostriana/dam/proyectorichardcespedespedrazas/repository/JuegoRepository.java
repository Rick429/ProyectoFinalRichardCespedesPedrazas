package com.salesianostriana.dam.proyectorichardcespedespedrazas.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;

public interface JuegoRepository extends JpaRepository <Juego, Long>{
	
	List<Juego> findByNombreContainsOrderByNombreAsc(String nombre);
	List<Juego> findByCategoriaIdCategoriaAndDisponibilidadTrueOrderByNombreAsc(Long id);
	List<Juego> findTop5ByOrderByFechaAltaDesc();
	
}
