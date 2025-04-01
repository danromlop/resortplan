export interface ReservaExistente {
  id:             number;
  restaurante:    Restaurante;
  turno:          Turno;
  nombreCliente:  string;
  numeroPersonas: number;
  observaciones:  string;
  fechaReserva:   Date;
}

export interface Restaurante {
  id:          number;
  nombre:      string;
  capacidad:   number;
  descripcion: string;
}

export interface Turno {
  id:          number;
  tipo:        string;
  horaInicio:  string;
  horaFin:     string;
  restaurante: Restaurante;
}
