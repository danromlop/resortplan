import { DatePipe } from '@angular/common';
import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { RestaurantesService } from '../../../services/restaurantes.service';
import { Turno } from '../../../interfaces/turno';
import { ReservasService } from '../../../services/reservas.service';
import { Reserva } from '../../../interfaces/reserva';
import { Restaurante } from '../../../interfaces/restaurante';

@Component({
  selector: 'app-reserva-restaurante-grid',
  imports: [RouterLink, DatePipe],
  templateUrl: './reserva-restaurante-grid.component.html',
  styleUrl: './reserva-restaurante-grid.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReservaRestauranteGridComponent {

  restauranteService = inject(RestaurantesService);
  reservasService = inject(ReservasService);

  turnos = signal<Turno[]>([]);
  restaurante = signal<Restaurante| null>(null)

  today: number = Date.now();

  nextSixDays: Date[] = [];


  ngOnInit(){
    console.log(this.today);


    for (let i = 1; i <= 6; i++) {
      const futureDate = new Date(this.today);
      futureDate.setDate(futureDate.getDate() + i);
      this.nextSixDays.push(futureDate);
    }


    console.log("REST ID " + this.reservasService.getReserva.restauranteId)
    const idRest =  this.reservasService.getReserva.restauranteId;
    if(idRest){
      this.restauranteService.cargarTurnosPorId(idRest)
      .subscribe(turnos => {
        this.turnos.update(() => turnos);
      });

      this.restauranteService.cargaRestaurantePorId(idRest).subscribe(rest => this.restaurante.update(()=> rest));
    }









  }


}
