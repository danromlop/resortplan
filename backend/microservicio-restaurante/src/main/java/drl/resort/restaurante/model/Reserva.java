package drl.resort.restaurante.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas") // Asegúrate de que coincide con la tabla en la BD
public class Reserva {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "restaurante_id", nullable = false)
	    private Restaurante restaurante;

	    @ManyToOne
	    @JoinColumn(name = "turno_id", nullable = false)
	    private Turno turno;

	    @Column(name = "nombre_cliente", nullable = false, length = 255)
	    private String nombreCliente;

	    @Column(name = "numero_personas", nullable = false)
	    private int numeroPersonas;

	    @Column(columnDefinition = "TEXT")
	    private String observaciones;

	    @Column(name = "fecha_reserva", nullable = false)
	    private LocalDate fechaReserva;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Restaurante getRestaurante() {
			return restaurante;
		}

		public void setRestaurante(Restaurante restaurante) {
			this.restaurante = restaurante;
		}

		public Turno getTurno() {
			return turno;
		}

		public void setTurno(Turno turno) {
			this.turno = turno;
		}

		public String getNombreCliente() {
			return nombreCliente;
		}

		public void setNombreCliente(String nombreCliente) {
			this.nombreCliente = nombreCliente;
		}

		public int getNumeroPersonas() {
			return numeroPersonas;
		}

		public void setNumeroPersonas(int numeroPersonas) {
			this.numeroPersonas = numeroPersonas;
		}

		public String getObservaciones() {
			return observaciones;
		}

		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}

		public LocalDate getFechaReserva() {
			return fechaReserva;
		}

		public void setFechaReserva(LocalDate fechaReserva) {
			this.fechaReserva = fechaReserva;
		}
	    
	    

}
