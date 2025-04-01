package drl.resort.restaurante.service;

import java.time.LocalDate;
import java.util.List;


import drl.resort.restaurante.model.Reserva;


public interface IReservaService {
	
	// Método para obtener reservas de una fecha específica
    public List<Reserva> obtenerReservasPorFecha(LocalDate fecha) ;
    
    public List<Reserva> obtenerReservasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);

}
