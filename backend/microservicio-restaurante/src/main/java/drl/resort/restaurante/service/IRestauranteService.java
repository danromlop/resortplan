package drl.resort.restaurante.service;

import java.util.List;

import drl.resort.restaurante.model.Restaurante;

public interface IRestauranteService {

	List<Restaurante> buscarTodos();
	
	Restaurante buscarPorId(Long idRestaurante);
}
