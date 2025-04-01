import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Restaurante } from '../interfaces/restaurante';
import { environment } from '../../environments/environment.development';
import { Turno } from '../interfaces/turno';
import { map, Observable } from 'rxjs';

const RESTAURANTE_URL:string = 'http://localhost:8080/restaurantes'

@Injectable({
  providedIn: 'root'
})
export class RestaurantesService {

  constructor() {
    this.cargarRestaurantes();
   }

  private http = inject(HttpClient);

  restaurantes = signal<Restaurante[]>([]);
  turnos = signal<Turno[]>([]);


  cargarRestaurantes(){
    return this.http.get<Restaurante[]>(RESTAURANTE_URL).subscribe( (datos) =>
      this.restaurantes.update((rest) => datos)
    )
  }

  cargaRestaurantePorId(id: number):Observable<Restaurante>{
    return this.http.get<Restaurante>(RESTAURANTE_URL + "/" + id);
  }

  cargarTurnosPorId(id: number): Observable<Turno[]> {
    return this.http.get<Turno[]>(RESTAURANTE_URL + "/turnos/" + id)
      .pipe(
        map((datos) => datos.map(turno => ({
          ...turno,
          horaInicio: turno.horaInicio.substring(0, 5), // Opcional: Formato de hora
          horaFin: turno.horaFin.substring(0, 5),
        })))
      )
  }


}
