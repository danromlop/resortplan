package io.danromlop.resort.habitaciones.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.danromlop.resort.habitaciones.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findAll();
	
	Optional<Cliente> findById(Long id);
}
