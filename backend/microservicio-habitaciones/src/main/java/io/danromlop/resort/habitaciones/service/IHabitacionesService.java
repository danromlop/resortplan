package io.danromlop.resort.habitaciones.service;

import java.util.List;

import io.danromlop.resort.habitaciones.model.Habitacion;

public interface IHabitacionesService {
	
	List<Habitacion> getHabitaciones();
	Habitacion obtenerHabitacionPorNumero(String num);

}
