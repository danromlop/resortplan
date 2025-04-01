package drl.resort.restaurante.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import drl.resort.restaurante.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

	List<Restaurante> findAll();
	
	 // Buscar un restaurante por su nombre (ignorando mayúsculas/minúsculas)
    List<Restaurante> findByNombreIgnoreCase(String nombre);

    //Buscar restaurantes con capacidad mayor o igual a un número dado
    List<Restaurante> findByCapacidadGreaterThanEqual(int capacidad);
    
    Restaurante findById(long id);
}
