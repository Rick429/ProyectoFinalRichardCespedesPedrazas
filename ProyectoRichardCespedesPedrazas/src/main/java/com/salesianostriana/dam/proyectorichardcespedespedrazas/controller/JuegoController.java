package com.salesianostriana.dam.proyectorichardcespedespedrazas.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Categoria;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.service.base.CategoriaService;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.service.base.JuegoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
/**
 * Clase JuegoController
 * 
 * @author RichardCespedes
 *
 */
public class JuegoController {

	private final JuegoService juegoServicio;
	private final CategoriaService categoriaServicio;
	
	
	@GetMapping({"/", "/Juego"})
	public String index(Model model,
		@RequestParam("q") Optional<String> consulta) {
			
			List<Juego> juegos = new ArrayList<>();
			if (consulta.isEmpty()) {
				for (Juego juego : juegoServicio.findAll()) {
					if(juego.isDisponibilidad()) {
						juegos.add(juego);
					}
				}
				model.addAttribute("juegos", juegos);
				
			} else {
				juegos = juegoServicio.buscarPorNombre(consulta.get());
			}
			model.addAttribute("carruseles", juegoServicio.juegosNuevos());
			model.addAttribute("juegos", juegos);					

		return "index";
	}
	
	@GetMapping("/Form")
	public String muestraFormulario(Model model) {
		model.addAttribute("juego", new Juego());
		return "formulario";
	}
	

	@GetMapping("/Juego/{id}")
	public String unJuego(
			@PathVariable("id") Long juegoId, Model model) {
		Juego j = juegoServicio.findById(juegoId);
		model.addAttribute("juego", j);
		
		return "juego";
	}
	
	@GetMapping("/Juego/Categoria/{id}")
	public String todosLosJuegos(Model model, 
			@PathVariable("id") Long id) {
		model.addAttribute("juegos", juegoServicio.todosLosJuegosDeUnaCategoria(id));					
		return "index";
	}
	@GetMapping("/Juego/disp")
	public String todosLosJuegosNoDisponibles(Model model) {
		List<Juego> juegos = new ArrayList<>();

			for (Juego juego : juegoServicio.findAll()) {
				if(!juego.isDisponibilidad()) {
					juegos.add(juego);
			
			}
			model.addAttribute("juegos", juegos);
			
		}			
		return "index";
	}
	@GetMapping("/Juego/Novedad")
	public String todosLosJuegos(Model model) {

		model.addAttribute("juegos", juegoServicio.juegosNuevos());					
	
		return "index";
	}
	
	@GetMapping("/Juego/Oferta")
	public String todosLosJuegosConDescuento(Model model){
		List<Juego> juegos = new ArrayList<>();	
		int cero = 0;
			for (Juego juego : juegoServicio.findAll()) {
				if(juego.getDescuento()>cero) {
					juegos.add(juego);
				}
			}
			model.addAttribute("juegos", juegos);					
		return "index";
	}

	@PostMapping("/submit/{id}")
	public String procesaFormulario(@ModelAttribute("juego") Juego juego) {
		juego.setFechaAlta(LocalDate.now());
		juegoServicio.save(juego);
		return "redirect:/";
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long juegoId, Model model) {
		Juego j = juegoServicio.findById(juegoId);
		juegoServicio.delete(j);
		return "redirect:/";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long juegoId, Model model) {
		Juego j = juegoServicio.findById(juegoId);
		model.addAttribute(j);	
		//String[] categorias = new String[] { "Acción", "Aventura", "FPS", "Deporte", "Casual", "Estrategia", "Shooter" };
		//model.addAttribute("categorias", categoriaServicio);

		return "formulario";
	}
	
	@ModelAttribute("Juego")
	public List<Juego> juegos(){
	
		return juegoServicio.findAll();
	}
	@ModelAttribute("categorias")
	public List<Categoria> categorias(){
		return categoriaServicio.findAll();
	}

	

}
