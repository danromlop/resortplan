package drl.resort.restaurante.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import drl.resort.restaurante.model.Restaurante;
import drl.resort.restaurante.model.Turno;
import drl.resort.restaurante.repositories.RestauranteRepository;
import drl.resort.restaurante.service.ITurnoService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private ITurnoService turnoService;
	
	
	@GetMapping("")
	public List<Restaurante> prueba(){
		return restauranteRepository.findAll();
	}
	
	@GetMapping("/turnos/{id}")
	public List<Turno> getTurnosPorRestaurante(@PathVariable Long id){
		return turnoService.obtenerTurnosPorRestaurante(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Restaurante> getRestaurantePorId(@PathVariable Long id){
		return restauranteRepository.findById(id);
	}
	
	
}
