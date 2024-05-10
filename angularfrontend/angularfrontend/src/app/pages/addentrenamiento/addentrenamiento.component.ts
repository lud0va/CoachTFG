import {Component, OnInit} from '@angular/core';
import {Entrenamiento} from "../../model/entrenamiento/entrenamiento";
import {ActivatedRoute, Router} from "@angular/router";
import {DietasService} from "../../services/dietas/dietas.service";
import {EntrenamientosService} from "../../services/entrenamientos/entrenamientos.service";
import {CoacheeService} from "../../services/coachee/coachee.service";
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {EjerciciosService} from "../../services/ejercicios/ejercicios.service";
import {Ejercicio} from "../../model/ejercicio/ejercicio";
import {FormBuilder, Validators} from "@angular/forms";
import {EjerciciosParam} from "./ejerciciosParam";

@Component({
  selector: 'app-addentrenamiento',
  templateUrl: './addentrenamiento.component.html',
  styleUrl: './addentrenamiento.component.css'
})
export class AddentrenamientoComponent implements OnInit  {
  idcoachee= this.actroute.snapshot.params['id'];
  coachee?: Coachee;
  entrenamientos?: Entrenamiento[];
  activated=true
  selectedEntrenamientoId?:number
  daysOfWeek: string[] = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'];
  selectedDay: string = 'Lunes';
  ejercicio?:Ejercicio;
  form=this.formBuilder.group({

    nombre:['',[Validators.required]],
    dificultad:['',Validators.required],
    tipo:['',Validators.required],
    descripcion:['',Validators.required]
  })
  constructor(private formBuilder:FormBuilder,private router:Router,private actroute: ActivatedRoute, private ejerciciosService:EjerciciosService , private entrenamientoService: EntrenamientosService, private coacheeServices: CoacheeService) {
  }
  cargarEntrenamientos(){

    this.entrenamientoService.getAllByCoacheeId(this.idcoachee).subscribe({
      next:value => {
        this.entrenamientos=value
      },error:err => {
        console.log(err)
      }
    })
  }
  ngOnInit(): void {




    this.coacheeServices.getCoacheeById(this.idcoachee).subscribe({
      next: value => {
        this.coachee = value
      }, error: error => {
        console.log(error)
      }


    })
    this.cargarEntrenamientos()

  }
  addEntrenamiento(){
      var entrenamiento={

        diaSemana:this.selectedDay,
        coachee:this.coachee
      }
      this.entrenamientoService.addEntrenamiento(entrenamiento).subscribe({
        next:value => {
        this.cargarEntrenamientos()
        },error:err => {
          console.log(err)
        }

      })
  }
  addEjercicio(){
    var param=this.form.value as EjerciciosParam
    this.ejercicio={
      nombre:param.nombre,
      descripcion:param.descripcion,
      dificultad:param.dificultad,
      tipo:param.tipo,
      identrenamiento:this.selectedEntrenamientoId

    }
    this.ejerciciosService.addEjercicio(this.ejercicio).subscribe({
      next:value => {
        this.cargarEntrenamientos()
      },error:err => {
        console.log(err)
      }

    })
  }
  selectDay(day:string){
    this.selectedDay=day
  }
  onSelectEntrenamiento(entrenamiento:Entrenamiento){
    this.activated=false;
    this.selectedEntrenamientoId=entrenamiento.id;
  }
}
