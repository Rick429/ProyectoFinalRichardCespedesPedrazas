package com.salesianostriana.dam.proyectorichardcespedespedrazas.service.base;
import java.util.List;
import org.springframework.stereotype.Service;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.repository.JuegoRepository;

@Service
public class JuegoService extends BaseService<Juego, Long, JuegoRepository>{

//	public List<Juego>tresPorFecha(LocalDate fecha) {
//		return repositorio.findTop3ByFechaOrderByFecha(fecha);
//	}
	public List<Juego> buscarPorNombre(String a) {
		return this.repositorio.findByNombreContainsOrderByNombreAsc(a);
	}
	
	public List<Juego> todosLosJuegosDeUnaCategoria(Long id) {
		return this.repositorio.findByCategoriaIdCategoriaOrderByNombreAsc(id);
	}
}