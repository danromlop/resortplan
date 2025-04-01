import { Component, inject } from '@angular/core';
import { RestaurantesService } from '../../services/restaurantes.service';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent {

  restauranteService = inject(RestaurantesService);



}
