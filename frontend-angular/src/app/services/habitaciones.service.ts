import { HttpClient } from '@angular/common/http';
import { inject, Injectable, signal } from '@angular/core';
import { Habitacion } from '../interfaces/habitacion';
import { catchError, map, Observable, throwError } from 'rxjs';

const HABITACIONES = 'http://localhost:8082/habitaciones/'

@Injectable({
  providedIn: 'root'
})
export class HabitacionesService {

  private http = inject(HttpClient);



  constructor() { }


  getHabitacionPorNumero(num: string): Observable<Habitacion>{

    return this.http.get<Habitacion>(HABITACIONES + num).pipe(
      map(data => {
        if( !data){
          throw {message: "Habitacion no encontrada"}
        }
        if( !data.cliente){
          throw {message: "Habitacion no ocupada"}
        }
        return data;
      }),
      catchError(error => {
        console.error("Error en la petición:", error);
        if(error.message){

          return throwError(() => new Error(error.message));
        }else{
          // no muestra este mensaje de error cuando el microservicio está caido
          return throwError(() => new Error("Error al obtener la habitación. Intente nuevamente más tarde."));
        }
      })

    );


  }





}
