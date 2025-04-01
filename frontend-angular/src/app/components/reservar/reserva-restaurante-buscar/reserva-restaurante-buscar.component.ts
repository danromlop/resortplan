import { Component, inject, signal } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { FormUtils } from '../../../utils/form-utils';
import { HabitacionesService } from '../../../services/habitaciones.service';
import { RestaurantesService } from '../../../services/restaurantes.service';
import { Habitacion } from '../../../interfaces/habitacion';
import { ReservaRestauranteBuscarClienteComponent } from './reserva-restaurante-buscar-cliente/reserva-restaurante-buscar-cliente.component';

@Component({
  selector: 'app-reserva-restaurante-buscar',
  imports: [ReservaRestauranteBuscarClienteComponent, ReactiveFormsModule],
  templateUrl: './reserva-restaurante-buscar.component.html',
  styleUrl: './reserva-restaurante-buscar.component.css',
})
export class ReservaRestauranteBuscarComponent {

  private fb = inject(FormBuilder);
  private habitacionService = inject(HabitacionesService);
  restauranteService = inject(RestaurantesService);


  habEncontrada = signal<boolean>(false);
  errorHab = signal<boolean>(false);
  errorHabMessage = signal<string>("")
  ocupantesHab = signal<string>("");

  habitacion = signal<Habitacion>({
    numero: '',
    cliente: {
      id: 0,
      nombre: '',
      apellidos: '',
      numPersonas: 0
    }
  });




  myForm: FormGroup = this.fb.group({
    habitacion: ['', [Validators.required, Validators.min(0)]]
  });

  formUtils = FormUtils;

  onSave(){
    this.habEncontrada.update(d => d = false)
    this.errorHab.update(d => d = false)
    if (this.myForm.invalid){
      this.myForm.markAllAsTouched()
      return;
    }

    this.habitacionService.getHabitacionPorNumero(this.myForm.get('habitacion')?.value).subscribe({
      next: (data) => {
        console.log("a")

      this.habEncontrada.update(d => d = true);
      this.habitacion.update(hab => hab = data);
      },
      error: (err) =>{
        console.log(err.message)
        this.errorHab.update(d => d = true);
        this.errorHabMessage.update(d => d = err.message);
      }
    });



    console.log(this.myForm.get('habitacion')?.value);
    console.log(this.myForm.value);
  }



 }
