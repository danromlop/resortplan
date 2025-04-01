package drl.resort.restaurante.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import drl.resort.restaurante.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	
	List<Reserva> findByFechaReserva(LocalDate fechaReserva);
	
    // Buscar reservas en un rango de fechas (desde una fecha hasta otra, ambas incluidas)
    List<Reserva> findByFechaReservaBetween(LocalDate fechaInicio, LocalDate fechaFin);

}
