package com.salesianostriana.dam.proyectorichardcespedespedrazas;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Categoria;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.model.Juego;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.repository.CategoriaRepository;
import com.salesianostriana.dam.proyectorichardcespedespedrazas.repository.JuegoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
/**
 * Clase InitData
 * 
 *
 * @author RichardCespedes
 *
 */
public class InitData {
	private final JuegoRepository repository;
	private final CategoriaRepository categoriaRepository; 

	@PostConstruct

	/**
	 * Carga datos de los juegos y las categorias
	 */
	public void run() {
		
		String[] categorias = new String[] { "Acción", "Aventura", "FPS", "Deporte", "Casual", "Estrategia", "Shooter", "Simulación"};

		for(String categoria : categorias) {
			categoriaRepository.save(new Categoria(categoria));
		}
		
		int cinco = 5;
		LocalDate fecha = LocalDate.now().plusDays(cinco);
		LocalDate fechaD = LocalDate.now();
		Juego j1 = new Juego("ASSASIN’S CREED VALHALLA",
				"Ponte en la piel de Eivor, una leyenda vikinga en busca de gloria. Explora la Inglaterra de los años oscuros mientras saqueas a tus enemigos, haces prosperar tu asentamiento y consolidas tu poder político."
						+ "• Dirige épicos saqueos vikingos contra fortalezas y tropas sajonas."
						+ "• Lucha a dos manos con poderosas armas y revive el brutal estilo de combate de los vikingos."
						+ "• Ponte a prueba con los enemigos más variados y letales jamás vistos en Assassin's Creed."
						+ "• Moldea a tu personaje con cada decisión y forja tu camino hacia la gloria."
						+ "• Explora un mundo abierto ambientado en los años oscuros, desde las costas de Noruega hasta los reinos de Inglaterra."
						+ "• Personaliza tu experiencia haciendo prosperar el asentamiento de tu clan.",
				"Standard Edition", "https://i.ibb.co/zHr3DxR/Assasins-Valhalla.jpg",
				"https://i.ibb.co/941kRNr/Assasins-Valhalla1.jpg", "https://i.ibb.co/3TNj1D7/Assasins-Valhalla2.jpg",
				"https://i.ibb.co/JqRPqVL/Assasins-Valhalla3.jpg", "https://i.ibb.co/kyMM5xv/Assasins-Valhalla4.jpg",
				59.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Aventura"), fecha);

		Juego j2 = new Juego("Scott Pilgrim vs. The World: The Game",
				"¡Redescubre el querido beat 'em up arcade en 2D inspirado en los emblemáticos cómics y la película de Scott Pilgrim contra el mundo en esta Complete Edition!"
						+ "Incluye el juego base Scott Pilgrim vs. The World™: The Game y los contenidos descargables originales de Knives Chau y Wallace."
						+ "Juega con tus personajes preferidos: Scott Pilgrim, Ramona Flowers, Knives Chau, Stephen Stills y muchos más. Sube de nivel, aprende nuevas habilidades, desbloquea objetos y modos secretos, invoca a poderosos aliados y mucho más."
						+ "¡Forma equipo con amigos y combinad vuestras habilidades para luchar contra las oleadas de enemigos, o compite contra ellos en minijuegos como el de balón prisionero, mientras derrotas a la Liga de los Malvados Ex de Ramona!",
				"Complete Edition", "https://i.ibb.co/PYPRWx9/scott.jpg", "https://i.ibb.co/CmKVq9K/scott1.jpg",
				"https://i.ibb.co/0CYfpdK/scott2.jpg", "https://i.ibb.co/PhRLHr7/scott3.jpg",
				"https://i.ibb.co/2cPY07b/scott4.jpg", 14.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Aventura") , fecha);

		Juego j3 = new Juego("Watch Dogs: Legion",
				"Forma una resistencia con prácticamente cualquiera que te encuentres, mientras hackeas, te infiltras y luchas para salvar a Londres de la debacle en un futuro próximo.",
				"GOLD EDITION", "https://i.ibb.co/PFNPnHN/Watch-Dogs-Legion.jpg",
				"https://i.ibb.co/CnV7qKx/Watch-Dogs-Legion1.jpg", "https://i.ibb.co/5M5m2c0/Watch-Dogs-Legion2.jpg",
				"https://i.ibb.co/T1n9FRK/Watch-Dogs-Legion3.jpg", "https://i.ibb.co/VxGhvLt/Watch-Dogs-Legion4.jpg",
				99.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Acción") , fecha);

		Juego j4 = new Juego("Tom Clancy's Rainbow Six Siege",
				"Sumérgete en un explosivo juego 5v5, alta competición y emocionantes enfrentamientos de equipos PvP, de forma individual o con amigos. Tom Clancy's Rainbow Six® Siege es una experiencia en constante expansión con oportunidades sin fin para perfeccionar tu estrategia y llevar a tu equipo a la victoria."
						+ "Rainbow Six Siege evoluciona continuamente. Cada temporada ofrece contenidos, agentes, habilidades, eventos, armas y mapas nuevos."
						+ "¡Mejora tu experiencia con la Deluxe Edition de Tom Clancy's Rainbow Six® Siege! Incluye el juego completo y los 16 agentes del Year 1 y Year 2",
				"DELUXE EDITION", "https://i.ibb.co/YXv3k41/Tom-Clancys-Six.webp",
				"https://i.ibb.co/BwhW4hK/Tom-Clancys-Six1.webp", "https://i.ibb.co/SsrXVk8/Tom-Clancys-Six2.webp",
				"https://i.ibb.co/41yJ11F/Tom-Clancys-Six3.webp", "https://i.ibb.co/WFqmK4t/Tom-Clancys-Six4.jpg",
				29.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("FPS") , fecha);
		Juego j5 = new Juego("Assassin's Creed Odyssey",
				"Escribe tu propia odisea legendaria y vive aventuras épicas en un mundo donde cada decisión importa.  Tu familia te ha condenado a muerte y debes embarcarte en un viaje fascinante que te convertirá de simple mercenario a héroe griego legendario, mientras descubres la verdad sobre tu pasado. Sigue tu propio camino en este mundo forjado por Dioses y mortales y azotado por la guerra, allá donde el mar rompe contra las montañas. Conoce a personajes históricos de la antigua Grecia e interactúa con ellos en este momento decisivo de la historia que dio forma a la civilización occidental."
						+ "En Assassin's Creed® Odyssey, la libertad de decisión del jugador llega a un nivel totalmente innovador nunca antes visto en la saga. Elige el tipo de héroe que quieres ser y cambia el mundo a tu alrededor a través de las relaciones que construyes con otros personajes y de las decisiones que tomes a lo largo de tu odisea; serás tú quien controle tu destino. Personaliza tu equipo y domina nuevas habilidades especiales, ajustando las habilidades de tu héroe a tu estilo de juego. Lucha por toda Grecia en sangrientas batallas en tierra y mar, y conviértete en una figura legendaria.",
				"ULTIMATE EDITION", "https://i.ibb.co/Vw8tSRM/Assassins-Creed-Odyssey.webp",
				"https://i.ibb.co/yVW8KzG/Assassins-Creed-Odyssey1.webp",
				"https://i.ibb.co/x3HC59Z/Assassins-Creed-Odyssey2.jpg",
				"https://i.ibb.co/7bFXqvP/Assassins-Creed-Odyssey3.webp",
				"http://tribecareview.es/wp-content/uploads/2018/11/ac-odyssey-1024x575.jpg", 114.99, 75, true, fechaD,
				categoriaRepository.findFirstByNombre("Acción"), fecha);
		Juego j6 = new Juego("UNO",
				"azte con la colección completa de uno de los juegos más emblemáticos de todos los tiempos: UNO® Ultimate Edition contiene UNO®, UNO FLIP!™, UNO® Fenyx's Quest y cartas temáticas de Just Dance® 2017 y Rayman®, entre otras. Combina cartas por color o valor y compite contra otros jugadores. Prueba UNO FLIP!™ y ya verás lo interesante que se pone la partida. ¡Pásate al lado oscuro y descubre nuevas cartas de acción como Roba cinco y Salta a todos! Juega en la Isla Dorada y gánate el apoyo de poderosas deidades en el nuevo UNO® Fenyx's Quest, un nuevo modo de juego cargado de acción con los personajes de Immortals Fenyx Rising™. ¡Dale vidilla al juego con los mazos temáticos adicionales y los contenidos descargables, y exprime al máximo tus partidas de UNO®!",
				"ULTIMATE EDITION", "https://i.ibb.co/5G5c6rW/uno.jpg", "https://i.ibb.co/7SppG24/uno1.webp",
				"https://i.ibb.co/tHk8Hr5/uno2.webp", "https://i.ibb.co/kxm7rb6/uno3.webp",
				"https://i.ibb.co/566msFn/uno4.webp", 19.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Casual"), fecha);

		Juego j7 = new Juego("Immortals Fenyx Rising", "ERES LA ÚLTIMA ESPERANZA DE LOS DIOSES\r\n" + "\r\n"
				+ "Ponte en la piel de Fenyx y salva a los dioses griegos de una tenebrosa maldición. Enfréntate a bestias mitológicas, domina los poderes legendarios de los dioses y derrota a Tifón, el titán más terrorífico de la mitología griega, en una lucha épica que pasará a la historia." + "- ENFRÉNTATE A ENEMIGOS MITICOS"
				+ "Pelea contra Medusa, Minotauro o cíclopes extraídos de las leyendas en trepidantes combates aéreos y cuerpo a cuerpo en los que tendrás que combinar tus armas con las habilidades que te otorgarán los dioses.\r\n"
				+"- BLANDE EL PODER DE LOS DIOSES"
				+ "Los dioses del Olimpo te cubrirán de bendiciones. Utilízalas para enfrentarte a animales mitológicos, resolver rompecabezas antiquísimos y explorar un inmenso mundo abierto."
				+ "*El contenido definitivo y las fechas de lanzamiento pueden cambiar. Algunas características podrían no estar disponibles en el momento del lanzamiento. El contenido puede estar disponible para su compra y mediante sorteos por separado a la entera discreción de Ubisoft en cualquier momento. Requisitos del sistema por confirmar. Consulta los requisitos del sistema y las restricciones y detalles del producto antes de comprarlo y antes de canjear la reserva cuando llegue el lanzamiento.",
				"STANDARD EDITION", "https://i.ibb.co/GRsBfbx/Immortals-Fenyx.jpg",
				"https://i.ibb.co/3p241X2/Immortals-Fenyx1.jpg", "https://i.ibb.co/3cn6BwT/Immortals-Fenyx2.webp",
				"https://i.ibb.co/J7LmMwP/Immortals-Fenyx3.webp", "https://i.ibb.co/K6YZ72G/Immortals-Fenyx4.jpg",
				59.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Acción"), fecha);

		Juego j8 = new Juego("Riders Republic",
				"¡Reserva ya para conseguir el pack Conejito! Incluye un atuendo de conejito personalizado y un gráfico para la tabla de snow."
						+ "La Edición Definitiva incluye el pase del Año 1 y cuatro packs estéticos exclusivos. Packs Cósmico, Arcoíris, Neón y Estilo calavera.Coge tu bici, esquíes, tabla de snow o traje de alas y explora el paraíso de los deportes en mundo abierto en el que tú creas las reglas... o pasas de ellas."
						+ "• El pase del Año 1 incluye ocho kits exóticos que se desbloquearán a lo largo del año y el contenido adicional de deporte BMX cuando se publique, después del lanzamiento."
						+ "• Enfréntate a más de 50 jugadores a la vez en un gigantesco entorno multijugador."
						+ "• Compite en una carrera multitudinaria: ¡choca, grinda y ábrete paso hasta la meta!"
						+ "• Recorre un mundo abierto en bici, esquíes, tabla de snow o traje de alas en modo Carrera o en eventos multijugador."
						+ "*El contenido definitivo y las fechas de lanzamiento pueden cambiar. Algunas características podrían no estar disponibles en el momento del lanzamiento. El contenido puede estar disponible para su compra y mediante sorteos por separado a la entera discreción de Ubisoft en cualquier momento. Requisitos del sistema por confirmar. Consulta los requisitos del sistema y las restricciones y detalles del producto antes de comprarlo y antes de canjear la reserva cuando llegue el lanzamiento.",
				"ULTIMATE EDITION", "https://i.ibb.co/txHCVb4/Riders-Republic.webp",
				"https://i.ibb.co/T1KpCb6/Riders-Republic1.jpg", "https://i.ibb.co/dKZM6dF/Riders-Republic2.jpg",
				"https://i.ibb.co/zxFmzgF/Riders-Republic3.jpg", "https://i.ibb.co/K5TmgCn/Riders-Republic4.jpg",
				119.99, 8, true, fechaD, categoriaRepository.findFirstByNombre("Deporte"), fecha);

		Juego j9 = new Juego("Monopoly Plus", "Un juego de mesa que está vivo\r\n"
				+ "Una auténtica ciudad en 3D en el centro del tablero vive y evoluciona a medida que juegas. Posees un mundo en miniatura en el que cada barrio tiene su propia identidad y características. Sus amistosos habitantes interactuarán con tu progreso por todo el juego, celebrando tus logros, añadiendo toda una nueva dimensión a tu experiencia de juego. Siente que posees algo especial, y admira cómo se expande tu imperio ante tus propios ojos."
				+ "Juega a tu manera"
				+ "Puedes cambiar las reglas y adaptarlas a tu estilo de juego. Prueba el famoso modo Speed Die, para que el juego sea más divertido, o selecciona una de las seis reglas de la casa elegidas por miembros de la comunidad de Monopoly de todo el mundo.",
				"STANDARD EDITION", "https://i.ibb.co/GtgrFnY/Monopoly.webp", "https://i.ibb.co/4dzk6N0/Monopoly1.jpg",
				"https://i.ibb.co/hBZyL7W/Monopoly2.jpg", "https://i.ibb.co/Yth1Hmn/Monopoly3.jpg",
				"https://i.ibb.co/xjWv8n0/Monopoly4.jpg", 14.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Estrategia"), fecha);
		Juego j10 = new Juego("Far Cry 6",
				"Te damos la bienvenida a Yara, un paraíso tropical que se ha detenido en el tiempo. Como dictador de Yara, Anton Castillo está decidido a devolver a su nación la antigua gloria perdida por cualquier medio, y su hijo Diego sigue sus sangrientos pasos. Su despiadada opresión ha prendido la llama de la revolución." + "LUCHA POR LA LIBERTAD"
						+ "Encarna a Dani Rojas, habitante de Yara que se convertirá en guerrillero para liberar su nación."
						+ "\r\n" + "UNA YARA DESGARRADA"
						+ "Lucha contra las tropas de Anton en el Far Cry más grande hasta la fecha a lo largo de junglas, playas y Esperanza, la capital de Yara."
						+ "\r\n" + "POTENCIA DE FUEGO GUERRILLERA"
						+ "Sírvete de armas improvisadas, vehículos y amigos, los nuevos colmillos de alquiler, para reducir el tiránico régimen a cenizas."
						+ "Far Cry® 6 - Ultimate Edition incluye el juego completo y el siguiente contenido digital:"
						+ "EL SEASON PASS"
						+ "¡Amplía tu experiencia con el Season Pass* y su contenido adicional con los 3 DLC y mucho más!"
						+ "EL PACK ULTIMATE"
						+ "Recorre toda la isla sembrando el terror con el pack Ultimate",
				"ULTIMATE EDITION", "https://i.ibb.co/Yk49Ry5/Far-Cry-Six.jpg",
				"https://i.ibb.co/NLpcvxZ/Far-Cry-Six1.png", "https://i.ibb.co/bWFvrfV/Far-Cry-Six2.png",
				"https://i.ibb.co/YyHp6KX/Far-Cry-Six3.png", "https://i.ibb.co/x5bGNsV/Far-Cry-Six4.jpg", 119.99, 8,
				true, fechaD, categoriaRepository.findFirstByNombre("Shooter"), fecha);
		Juego j11 = new Juego("South Park The Stick of Truth",
				"Desde los peligrosísimos campos de batalla del patio de recreo de los de cuarto curso, un joven héroe se alzará para cumplir su destino como salvador de South Park. De los creadores de South Park, Trey Parker y Matt Stone, llega una misión épica para convertirte en… un tío guay. Presentamos South Park™: La Vara de la Verdad."
						+ "Durante mil años se ha librado una batalla sin igual. Humanos y elfos combaten en un conflicto eterno, interminable, por una única razón: La Vara de la Verdad. Pero los vientos de guerra están a punto de cambiar, el aviso de la llegada de un nuevo chaval se extiende por todas las tierras, una llegada que fue presagiada por las estrellas. Según las furgonetas de la profecía se alejan espantadas, tu aventura comienza…"
						+ "Usa armas legendarias para vencer a la gente cangrejo, los gnomos roba calzoncillos, hippies y otras fuerzas diabólicas. Descubre La Vara de la Verdad perdida y sé el nuevo amigo de Stan, Kyle, Cartman y Kenny. Si lo consigues salvarás South Park y asentarás tu estatus social en la escuela. Fracasa, y te llamarán… el Perdedor.",
				"STANDARD", "https://i.ibb.co/ZMWmNG5/South-Park-Stick.webp",
				"https://i.ibb.co/rfc0cmf/South-Park-Stick1.webp", "https://i.ibb.co/zHpmQn7/South-Park-Stick2.webp",
				"https://i.ibb.co/s5ZQPRD/South-Park-Stick3.webp", "https://i.ibb.co/fnGzjcm/South-Park-Stick4.jpg",
				29.99, 0, true, fechaD, categoriaRepository.findFirstByNombre("Aventura"), fecha);
		Juego j12 = new Juego("Eagle Flight",
				"¡Eagle Flight, desarrollado solo para realidad virtual, te lleva a los cielos de París para que vivas como nunca la libertad de volar!\r\n"
						+ "Cincuenta años después de que los humanos desaparecieran de la faz de la Tierra, la fauna y la flora se adueñaron de sus ciudades y convirtieron París en un asombroso parque urbano. Como águila, planearás entre monumentos emblemáticos, desde la torre Eiffel hasta la catedral de Notre Dame, y te adentrarás en callejones estrechos para luchar contra rivales y proteger tu territorio. ¡Eagle Flight te da libertad absoluta para explorar París a vista de pájaro!"
						+ "¡Siente cómo se te dispara la adrenalina con el multijugador para hasta seis jugadores! Usa tus habilidades de vuelo para llevar a tu equipo a la victoria en dos modos multijugador y libra frenéticas batallas aéreas. ¡Tanto si siempre has deseado conocer París a vista de pájaro como si quieres sentir la emoción de cazar como un ave de rapiña, Eagle Flight te permitirá hacer realidad tus sueños!",
				"STANDARD", "https://i.ibb.co/4SVFRqZ/Eagle-Flight.jpg", "https://i.ibb.co/yYXjshP/Eagle-Flight1.jpg",
				"https://i.ibb.co/dmmL0Yj/Eagle-Flight2.jpg", "https://i.ibb.co/Rj9hFJV/Eagle-Flight3.jpg",
				"https://i.ibb.co/tJFW0xZ/Eagle-Flight4.jpg", 19.99, 0, false, fechaD, categoriaRepository.findFirstByNombre("Simulación"), fecha);
		repository.save(j1);
		repository.save(j2);
		repository.save(j3);
		repository.save(j4);
		repository.save(j5);
		repository.save(j6);
		repository.save(j7);
		repository.save(j8);
		repository.save(j9);
		repository.save(j10);
		repository.save(j11);
		repository.save(j12);

	}
}
