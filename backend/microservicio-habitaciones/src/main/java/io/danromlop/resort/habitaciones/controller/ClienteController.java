package io.danromlop.resort.habitaciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.danromlop.resort.habitaciones.model.Cliente;
import io.danromlop.resort.habitaciones.model.Habitacion;
import io.danromlop.resort.habitaciones.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("")
	public List<Cliente> getClientes(){
		return clienteService.getClientes();
	}
	
	@GetMapping("/{idCliente}")
	public Optional<Cliente> getHabitacionPorNumero(@PathVariable("idCliente") Long idCliente){
		return clienteService.obtenerClientePorId(idCliente);
		
	}
	

}
