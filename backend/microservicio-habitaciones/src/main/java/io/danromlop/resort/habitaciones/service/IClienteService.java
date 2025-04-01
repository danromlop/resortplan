package io.danromlop.resort.habitaciones.service;

import java.util.List;
import java.util.Optional;

import io.danromlop.resort.habitaciones.model.Cliente;

public interface IClienteService {
	
	List<Cliente> getClientes();
	Optional<Cliente> obtenerClientePorId(Long id);

}
