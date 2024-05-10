import {Component, OnInit} from '@angular/core';
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {Dieta} from "../../model/dieta/dieta";
import {Entrenamiento} from "../../model/entrenamiento/entrenamiento";
import {DietasService} from "../../services/dietas/dietas.service";
import {EntrenamientosService} from "../../services/entrenamientos/entrenamientos.service";
import {CoacheeService} from "../../services/coachee/coachee.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Alimento} from "../../model/alimento/alimento";
import {Plato} from "../../model/plato/plato";

@Component({
  selector: 'app-coacheedetail',
  templateUrl: './coacheedetail.component.html',
  styleUrl: './coacheedetail.component.css'
})
export class CoacheedetailComponent implements OnInit {
  coachee?: Coachee;
  dietas?: Dieta[];
  entrenamientos?: Entrenamiento[];
  selectedEntrenamientoId?:number
  selectedDietaId?:number
  selectedPlatoId?:number

  constructor(private router:Router,private actroute: ActivatedRoute, private dietaService: DietasService, private entrenamientoService: EntrenamientosService, private coacheeServices: CoacheeService) {
  }
  ngOnInit(): void {
    const  idCoachee = this.actroute.snapshot.params['id'];


    this.coacheeServices.getCoacheeById(idCoachee).subscribe({
      next: value => {
        this.coachee = value
      }, error: error => {
        console.log(error)
      }


    })
    this.entrenamientoService.getAllByCoacheeId(idCoachee).subscribe({
      next:value => {
        this.entrenamientos=value
      },error:err => {
        console.log(err)
      }
    })
    this.dietaService.getAllByCoacheeId(idCoachee).subscribe({
      next:value => {
        this.dietas=value
      },error:err => {
        console.log(err)
      }
    })

  }
  onSelectEntrenamiento(entrenamiento:Entrenamiento){

    this.selectedEntrenamientoId=entrenamiento.id;
  }
  onSelectDieta(dieta:Dieta){
    this.selectedDietaId=dieta.id;
  }

  onSelectPlato(plato:Plato){
    this.selectedPlatoId=plato.id;
  }

 toAddEntrenamiento(){
    const  idCoachee = this.actroute.snapshot.params['id'];
   this.router.navigate(['addEntrenamiento',idCoachee]);

 }
  toAddDieta(){
    const  idCoachee = this.actroute.snapshot.params['id'];
    this.router.navigate(['addDieta',idCoachee]);
  }



}
