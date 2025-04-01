import { ChangeDetectionStrategy, Component, inject, input } from '@angular/core';
import { Habitacion } from '../../../../interfaces/habitacion';
import { RestaurantesService } from '../../../../services/restaurantes.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ReservasService } from '../../../../services/reservas.service';
import {  ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'reserva-restaurante-buscar-cliente',
  imports: [ReactiveFormsModule],
  templateUrl: './reserva-restaurante-buscar-cliente.component.html',
  styleUrl: './reserva-restaurante-buscar-cliente.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReservaRestauranteBuscarClienteComponent {

  private router = inject(Router);
  private activatedRoute = inject(ActivatedRoute)
  private fb = inject(FormBuilder);

  restauranteService = inject(RestaurantesService);
  reservasService = inject(ReservasService);


  habitacion = input.required<Habitacion>()


  myForm: FormGroup = this.fb.group({
    restaurante: [0, Validators.required],
    numPax: [0, Validators.required]
  });

  onSave(){
    if(this.myForm.valid){
      console.log(this.myForm.value);

      this.reservasService.actualizarReserva({restauranteId: this.myForm.controls["restaurante"].value});
      this.reservasService.actualizarReserva({numPersonas: this.myForm.controls["numPax"].value});
      this.reservasService.actualizarReserva({nombreCliente: this.habitacion().cliente.nombre + " " + this.habitacion().cliente.apellidos});


      console.log(this.reservasService.getReserva);

      this.router.navigate(['../cupos'], { relativeTo: this.activatedRoute });

    }
    //pdte añadir mensajes de error formualrio



  }


 }
