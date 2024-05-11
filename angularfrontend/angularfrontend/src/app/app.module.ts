import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { LoginComponent } from './pages/login/login.component';
import { NavComponent } from './shared/nav/nav.component';
import { MainComponent } from './pages/main/main.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {RegisterComponent} from "./pages/register/register.component";
import { CoacheeslistComponent } from './pages/coacheeslist/coacheeslist.component';
import { CoacheedetailComponent } from './pages/coacheedetail/coacheedetail.component';
import { AddentrenamientoComponent } from './pages/addentrenamiento/addentrenamiento.component';
import { AdddietasComponent } from './pages/adddietas/adddietas.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    NavComponent,
    MainComponent,
    RegisterComponent,
    CoacheeslistComponent,
    CoacheedetailComponent,
    AddentrenamientoComponent,
    AdddietasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
