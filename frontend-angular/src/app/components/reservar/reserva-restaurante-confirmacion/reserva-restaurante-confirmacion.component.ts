import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-reserva-restaurante-confirmacion',
  imports: [RouterLink],
  templateUrl: './reserva-restaurante-confirmacion.component.html',
  styleUrl: './reserva-restaurante-confirmacion.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReservaRestauranteConfirmacionComponent { }
