package com.salesianostriana.dam.proyectorichardcespedespedrazas.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;

public interface JuegoRepository extends JpaRepository <Juego, Long>{
	
//	@Query("select j from Juego j order by fecha desc limit 3")
//	List<Juego> findTop3ByFechaOrderByFecha(LocalDate fecha);
	List<Juego> findByNombreContainsOrderByNombreAsc(String nombre);
	List<Juego> findByCategoriaIdCategoriaOrderByNombreAsc(Long id);
}
