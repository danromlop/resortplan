package io.danromlop.resort.habitaciones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.danromlop.resort.habitaciones.model.Cliente;
import io.danromlop.resort.habitaciones.repositories.ClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public List<Cliente> getClientes() {

		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> obtenerClientePorId(Long id) {

		return clienteRepository.findById(id);
	}

}
