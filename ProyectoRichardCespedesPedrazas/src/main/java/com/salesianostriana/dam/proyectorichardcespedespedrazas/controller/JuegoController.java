package com.salesianostriana.dam.proyectorichardcespedespedrazas.controller;

import java.time.LocalDate;
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
public class JuegoController {

	private final JuegoService juegoServicio;
	private final CategoriaService categoriaServicio;
	
	
	@GetMapping({"/", "/Juego"})
	public String index(Model model,
		@RequestParam("q") Optional<String> consulta) {
			
			List<Juego> juegos;
			
			if (consulta.isEmpty()) {
				juegos = juegoServicio.findAll();
			} else {
				juegos = juegoServicio.buscarPorNombre(consulta.get());
			}

			model.addAttribute("juegos", juegos);					

			//return "index";
		//model.addAttribute("juegos", juegoServicio.findAll());
		//model.addAttribute("portada", juegoServicio.tresPorFecha();
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

	
	@GetMapping("{/Juego/Categoria/{id}}")
	public String todosLosJuegos(Model model, 
			@PathVariable("id") Long id) {
		model.addAttribute("juegos", juegoServicio.todosLosJuegosDeUnaCategoria(id));					
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
	
//	@ModelAttribute("Juego")
//	public List<Juego> juegos(){
//		return juegoServicio.findAll();
//	}
	@ModelAttribute("categorias")
	public List<Categoria> categorias(){
		return categoriaServicio.findAll();
	}

	
	/*@ModelAttribute("categoria_juego")
	public List<String> juegos2(){
		return List.of("Fantasia", "Acción", "Aventura");
	}
	
	<label>Tipo de alumno<label/>
	<select th:field= "*{tipo}">
	<option value ="">---</option>
	<option th:each="tipo : ${tipo_alumno}"
	th:value="${tipo} th:field="*texto">
	
	*/

}
