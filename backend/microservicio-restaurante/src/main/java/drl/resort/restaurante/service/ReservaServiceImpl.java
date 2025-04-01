package drl.resort.restaurante.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drl.resort.restaurante.model.Reserva;
import drl.resort.restaurante.repositories.ReservaRepository;

@Service
public class ReservaServiceImpl implements IReservaService {

	@Autowired
    private ReservaRepository reservaRepository;
	 
	@Override
    public List<Reserva> obtenerReservasPorFecha(LocalDate fecha) {
        return reservaRepository.findByFechaReserva(fecha);
    }
	
    @Override
    public List<Reserva> obtenerReservasEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        System.out.println("Buscando reservas desde: " + fechaInicio + " hasta: " + fechaFin);
        List<Reserva> reservas = reservaRepository.findByFechaReservaBetween(fechaInicio, fechaFin);
        System.out.println("Reservas encontradas: " + reservas.size());
        return reservas;
    }

}
