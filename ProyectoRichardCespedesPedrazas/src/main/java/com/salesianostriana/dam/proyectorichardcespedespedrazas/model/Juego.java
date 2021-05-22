package com.salesianostriana.dam.proyectorichardcespedespedrazas.model;

import java.time.LocalDate;
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
/**
 * Clase Juego
 * 
 * Contiene información de un juego
 * 
 * @author RichardCespedes
 *
 */
public class Juego {
	
	@Id
	@GeneratedValue 
	/**
	 * id de un juego
	 */
	private long id;
	/**
	 * nombre de un juego
	 */
	private String nombre;
	@Column(columnDefinition="TEXT")
	/**
	 * descripción de un juego
	 */
	private String descripcion;
	/**
	 * edicion de un juego
	 */
	private String edicion;
	/**
	 * imagenes del juego
	 */
	private String imagen1, imagen2, imagen3, imagen4, imagen5;
	/**
	 * precio de un juego
	 */
	private double precio;
	/**
	 * descuento de un juego
	 */
	private int descuento;
	/**
	 * disponibilidad del juego
	 */
	private boolean disponibilidad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	/**
	 * fecha limite del descuento
	 */
	private LocalDate fecha;
	@ManyToOne
	/**
	 * categoria del juego
	 */
	private Categoria categoria;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	/**
	 * fecha alta de un juego
	 */
	private LocalDate fechaAlta;
	
	
	/**
	 * Constructor de un juego con todos los parámetros
	 * 
	 * @param nombre nombre del juego
	 * @param descripcion descripción del juego
	 * @param edicion edición del juego
	 * @param imagen1 url de la imagen de la portada
	 * @param imagen2 url 1 imagen carrusel
	 * @param imagen3 url 2 imagen carrusel
	 * @param imagen4 url 3 imagen carrusel
	 * @param imagen5 url 4 imagen carrusel
	 * @param precio  precio del juego
	 * @param descuento porcentaje de descuento
	 * @param disponibilidad disponibilidad del juego
	 * @param fecha fecha limite del descuento
	 * @param categoria categoria del juego
	 * @param fechaAlta fecha de alta del juego
	 */
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
