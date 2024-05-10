import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {HeaderComponent} from "./shared/header/header.component";
import {FooterComponent} from "./shared/footer/footer.component";
import {AppModule} from "./app.module";

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [
    AppModule
  ],
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
}
