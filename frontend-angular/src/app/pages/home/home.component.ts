import { ChangeDetectionStrategy, Component } from '@angular/core';
import { NavBarComponent } from "../../components/shared/nav-bar/nav-bar.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [NavBarComponent, RouterOutlet],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class HomeComponent { }
