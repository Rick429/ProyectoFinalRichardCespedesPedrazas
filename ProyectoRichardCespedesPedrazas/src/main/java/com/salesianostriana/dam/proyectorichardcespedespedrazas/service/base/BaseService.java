package com.salesianostriana.dam.proyectorichardcespedespedrazas.service.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Clase BaseService
 * 
 * @author RichardCespedes
 *
 */
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

	@Autowired
	/**
	 * repositorio base
	 */
	protected R repositorio;
	
	/** 
	 * Almacenamos una nueva entidad a través del repositorio
	 * @param t  nueva entidad
	 * @return guarda una entidad en el repositorio
	 */
	public T save(T t) {
		return repositorio.save(t);
	}
	
	/**
	 * Localizamos una entidad en base a su Id
	 * @param id id de la entidad
	 * @return devuelve una entidad 
	 */
	public T findById(ID id) {
		return repositorio.findById(id).orElse(null);
	}
	
	/**
	 * Obtenemos todas las entidades de un tipo de entidad
	 * @return devuelve lista de todas la entidades de un tipo
	 */
	public List<T> findAll() {
		return repositorio.findAll();
	}
	
	/**
	 * Editamos una instancia de una entidad (si no tiene Id, la insertamos).
	 * @param t entidad modificada
	 * @return Guarda o edita una instancia de una entindad
	 */
	public T edit(T t) {
		return repositorio.save(t);
	}
	
	/**
	 * Eliminamos una instancia de una entidad
	 * @param t entidad a eliminar
	 */
	public void delete(T t) {
		repositorio.delete(t);
	}
	
	/**
	 * Eliminamos una instancia en base a su ID
	 * @param id id de la entidad a borrar
	 */
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
	
	
}

