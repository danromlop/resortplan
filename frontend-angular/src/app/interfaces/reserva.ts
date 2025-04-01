export interface Reserva{
  restauranteId: number;
  turnoId?: number;
  nombreCliente: string;
  numPersonas: number;
  observaciones?:string;
  fechaReserva: string;


}
