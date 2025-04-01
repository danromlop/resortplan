package io.danromlop.resort.habitaciones.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danromlop.resort.habitaciones.model.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
	
	List<Habitacion> findAll();
	
	Habitacion findByNumeroIgnoreCase(String numero);

}
