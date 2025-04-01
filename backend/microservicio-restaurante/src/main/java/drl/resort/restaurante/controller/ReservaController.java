package drl.resort.restaurante.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import drl.resort.restaurante.model.Reserva;
import drl.resort.restaurante.service.IReservaService;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
    private IReservaService reservaService;

    // Endpoint para obtener reservas por fecha
    @GetMapping("")
    public List<Reserva> obtenerReservasPorFecha(@RequestParam("fecha") String fecha) {
    	LocalDate fechaLocalDate = LocalDate.parse(fecha);  
        System.out.println("Buscando reservas para la fecha: " + fechaLocalDate);
        List<Reserva> reservas = reservaService.obtenerReservasPorFecha(fechaLocalDate);
        System.out.println("Reservas encontradas: " + reservas.size());
        return reservas;
    }
    
    // Endpoint para obtener reservas entre dos fechas
    @GetMapping("/rango")
    public List<Reserva> obtenerReservasEntreFechas(@RequestParam("inicio") String inicio, 
                                                    @RequestParam("fin") String fin) {
        LocalDate fechaInicio = LocalDate.parse(inicio);
        LocalDate fechaFin = LocalDate.parse(fin);
        return reservaService.obtenerReservasEntreFechas(fechaInicio, fechaFin);
    }
    
    
    
	
}
