package drl.resort.restaurante.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import drl.resort.restaurante.model.TipoTurno;
import drl.resort.restaurante.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {


    // Obtener todos los turnos por tipo (ALMUERZO o CENA)
    List<Turno> findByTipo(TipoTurno tipo);

    // Obtener turnos de un restaurante específico
    List<Turno> findByRestauranteId(Long restauranteId);

	
}
