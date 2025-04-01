package io.danromlop.resort.habitaciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.danromlop.resort.habitaciones.model.Habitacion;
import io.danromlop.resort.habitaciones.repositories.HabitacionRepository;

@Service
public class HabitacionesService implements IHabitacionesService {
	
	@Autowired
	HabitacionRepository habitacionRepository;

	@Override
	public List<Habitacion> getHabitaciones() {
		// TODO Auto-generated method stub
		return (List<Habitacion>) habitacionRepository.findAll();
	}

	@Override
	public Habitacion obtenerHabitacionPorNumero(String num) {
		return habitacionRepository.findByNumeroIgnoreCase(num);

		
	}
	
	

}
