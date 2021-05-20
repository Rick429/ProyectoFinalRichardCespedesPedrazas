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
public class Categoria {
	
	
	@Id
	@GeneratedValue
	private long idCategoria;
	private String nombre;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
	private List<Juego> listaJuegos = new ArrayList<>();
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	public void addJuego(Juego j) {
		this.listaJuegos.add(j);
		j.setCategoria(this);
	}
	

	public void removeJuego(Juego j) {
		this.listaJuegos.remove(j);
		j.setCategoria(null);
	}
	@Override
	public String toString() {
		return "Categoria: " + nombre;
	}
	
	
	

		
}
