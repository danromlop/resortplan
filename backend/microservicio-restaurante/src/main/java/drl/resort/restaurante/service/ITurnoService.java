package drl.resort.restaurante.service;

import java.util.List;

import drl.resort.restaurante.model.TipoTurno;
import drl.resort.restaurante.model.Turno;

public interface ITurnoService {
    

    public List<Turno> obtenerTurnosPorTipo(TipoTurno tipo);

    public List<Turno> obtenerTurnosPorRestaurante(Long restauranteId);

}
