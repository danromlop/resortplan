package io.danromlop.resort.habitaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.danromlop.resort.habitaciones.model.Habitacion;
import io.danromlop.resort.habitaciones.service.HabitacionesService;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionesController {

	@Autowired
	private HabitacionesService habitacionesService;
	
	@GetMapping("")
	public List<Habitacion> getHabitaciones(){
		return habitacionesService.getHabitaciones();
		
	}
	
	@GetMapping("/{numHab}")
	public Habitacion getHabitacionPorNumero(@PathVariable("numHab") String numHab){
		return habitacionesService.obtenerHabitacionPorNumero(numHab);
		
	}
	
}
