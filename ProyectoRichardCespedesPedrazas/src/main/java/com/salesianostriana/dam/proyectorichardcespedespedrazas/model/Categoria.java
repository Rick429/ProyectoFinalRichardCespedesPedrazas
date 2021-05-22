package com.salesianostriana.dam.proyectorichardcespedespedrazas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@AllArgsConstructor
@Entity
/**
 * Clase Categoria
 * 
 * Categorias de los juegos
 * 
 * @author RichardCespedes
 *
 */
public class Categoria {
	
	
	@Id
	@GeneratedValue
	/**
	 * Id de una categoria
	 */
	private long idCategoria;
	/**
	 * Nombre de una categoria
	 */
	private String nombre;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
	/**
	 * Lista de juegos de una misma categoria
	 */
	private List<Juego> listaJuegos = new ArrayList<>();
	
	/**
	 * Constructor de una categoria con 1 parámetro
	 * @param nombre nombre de la categoria
	 */
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	/**
	 * añade un juego 
	 * @param j juego
	 */
	public void addJuego(Juego j) {
		this.listaJuegos.add(j);
		j.setCategoria(this);
	}
	
	/**
	 * elimina un juego
	 * @param j juego
	 */

	public void removeJuego(Juego j) {
		this.listaJuegos.remove(j);
		j.setCategoria(null);
	}
	@Override
	public String toString() {
		return "Categoria: " + nombre;
	}
	
	
	

		
}
