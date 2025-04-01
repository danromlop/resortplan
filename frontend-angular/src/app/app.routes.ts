import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ReservarPageComponent } from './pages/reservar-page/reservar-page.component';
import { InformesPageComponent } from './pages/informes-page/informes-page.component';
import { HomeComponent } from './pages/home/home.component';
import { ReservaRestauranteBuscarComponent } from './components/reservar/reserva-restaurante-buscar/reserva-restaurante-buscar.component';
import { ReservaRestauranteGridComponent } from './components/reservar/reserva-restaurante-grid/reserva-restaurante-grid.component';
import { ReservaRestauranteConfirmacionComponent } from './components/reservar/reserva-restaurante-confirmacion/reserva-restaurante-confirmacion.component';

export const routes: Routes = [

  {
    path: '',
    component: LoginComponent
  },
  {path: 'home', component: HomeComponent,
    children: [
      {
        path: 'dashboard',
        component: DashboardComponent
      },
      {
        path: 'reservar',
        component: ReservarPageComponent,
        children:[
          {
            path: 'buscar',
            component: ReservaRestauranteBuscarComponent
          },
          {
            path: 'cupos',
            component: ReservaRestauranteGridComponent
          },
          {
            path: 'confirmar',
            component: ReservaRestauranteConfirmacionComponent
          }
        ]
      },
      {
        path: 'informes',
        component: InformesPageComponent,
      },
    ],
  }



];
