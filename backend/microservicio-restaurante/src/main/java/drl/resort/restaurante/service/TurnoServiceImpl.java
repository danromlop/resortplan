package drl.resort.restaurante.service;

import java.util.List;

import org.springframework.stereotype.Service;

import drl.resort.restaurante.model.TipoTurno;
import drl.resort.restaurante.model.Turno;
import drl.resort.restaurante.repositories.TurnoRepository;

@Service
public class TurnoServiceImpl implements ITurnoService{

	private final TurnoRepository turnoRepository;

	
    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }


    @Override
    public List<Turno> obtenerTurnosPorTipo(TipoTurno tipo) {
        return turnoRepository.findByTipo(tipo);
    }
    
    @Override
    public List<Turno> obtenerTurnosPorRestaurante(Long restauranteId) {
        return turnoRepository.findByRestauranteId(restauranteId);
    }

	

}
