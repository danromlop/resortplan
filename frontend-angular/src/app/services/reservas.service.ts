import { Injectable, signal } from '@angular/core';
import { Reserva } from '../interfaces/reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservasService {

  constructor() { }

  private reserva = signal<Partial<Reserva>>({});

  setReserva(nuevaReserva: Reserva) {
    this.reserva.set(nuevaReserva);
  }

  actualizarReserva(parcial: Partial<Reserva>) {
    if (this.reserva()) {
      this.reserva.set({ ...this.reserva()!, ...parcial });
    }
  }

  // **Getter** para obtener el valor actual de la reserva
  get getReserva(): Partial<Reserva> {
    return this.reserva();
  }

  getReservasExistentes(){

  }





}
