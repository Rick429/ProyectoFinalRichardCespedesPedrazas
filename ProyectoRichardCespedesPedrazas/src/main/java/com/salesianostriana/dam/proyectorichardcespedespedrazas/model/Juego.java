package com.salesianostriana.dam.proyectorichardcespedespedrazas.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @NoArgsConstructor
@AllArgsConstructor
@Entity
public class Juego {
	
	@Id
	@GeneratedValue 
	private long id;
	private String nombre;
	@Column(columnDefinition="TEXT")
	private String descripcion;
	private String edicion , imagen1, imagen2, imagen3, imagen4, imagen5;
	private double precio;
	private int descuento;
	private boolean disponibilidad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	@ManyToOne//(cascade = {CascadeType.ALL})
	private Categoria categoria;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAlta;
	
	

	public Juego(String nombre, String descripcion, String edicion, String imagen1, String imagen2, String imagen3,
			String imagen4, String imagen5, double precio, int descuento, boolean disponibilidad, LocalDate fecha, Categoria categoria, LocalDate fechaAlta) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.edicion = edicion;
		this.imagen1 = imagen1;
		this.imagen2 = imagen2;
		this.imagen3 = imagen3;
		this.imagen4 = imagen4;
		this.imagen5 = imagen5;
		this.precio = precio;
		this.descuento = descuento;
		this.disponibilidad = disponibilidad;
		this.fecha = fecha;
		this.categoria = categoria;
		this.fechaAlta = fechaAlta;
	}
	
	
	
	
	
}
