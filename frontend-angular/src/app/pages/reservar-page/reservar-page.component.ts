import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-reservar-page',
  imports: [ RouterOutlet],
  templateUrl: './reservar-page.component.html',
  styleUrl: './reservar-page.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReservarPageComponent { }
