import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MainComponent} from "./pages/main/main.component";
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";
import {CoacheeslistComponent} from "./pages/coacheeslist/coacheeslist.component";
import {CoacheedetailComponent} from "./pages/coacheedetail/coacheedetail.component";
import {AddentrenamientoComponent} from "./pages/addentrenamiento/addentrenamiento.component";
import {AdddietasComponent} from "./pages/adddietas/adddietas.component";

const routes: Routes = [
  {path:'',redirectTo:'/inicio',pathMatch:'full'},
  {path:'inicio',component:MainComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'coacheelist',component:CoacheeslistComponent},
  {path:'coachee/:id',component:CoacheedetailComponent},
  {path:'addEntrenamiento/:id',component:AddentrenamientoComponent},
  {path:'addDieta/:id',component:AdddietasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
