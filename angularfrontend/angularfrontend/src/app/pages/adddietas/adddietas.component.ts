import {Component, OnInit} from '@angular/core';
import {Dieta} from "../../model/dieta/dieta";
import {Plato} from "../../model/plato/plato";
import {ActivatedRoute, Router} from "@angular/router";
import {DietasService} from "../../services/dietas/dietas.service";
import {EntrenamientosService} from "../../services/entrenamientos/entrenamientos.service";
import {CoacheeService} from "../../services/coachee/coachee.service";
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {PlatosService} from "../../services/platos/platos.service";
import {AlimentosService} from "../../services/alimentos/alimentos.service";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-adddietas',
  templateUrl: './adddietas.component.html',
  styleUrl: './adddietas.component.css'
})
export class AdddietasComponent implements OnInit {
  selectedDietaId?:number
  selectedPlatoId?:number
  dietas?: Dieta[];
  coachee?: Coachee;
  idcoachee= this.actroute.snapshot.params['id'];
  activatedDieta=true
  activatedPlato=true
  activatedAlimento=true
  form=this.formBuilder.group({

    caloriasMaxDia:['',[Validators.required]],
    fija:['',Validators.required],
    finDieta:['',Validators.required],

  })
  formPlato=this.formBuilder.group({

    nombre:['',[Validators.required]],
    desc:['',Validators.required],
    Hora:['',Validators.required],
    calTotal:['',Validators.required]
  })
  formAlimentos=this.formBuilder.group({

    nom:['',[Validators.required]],
    descript:['',Validators.required],
    calorias:['',Validators.required],
    grasas:['',Validators.required],
    carbohidratos:['',Validators.required],
    proteinas:['',Validators.required],
    minerales:['',Validators.required],
    vitaminas:['',Validators.required]
  })
  constructor(private formBuilder:FormBuilder,private router:Router,private actroute: ActivatedRoute, private dietaService: DietasService,  private coacheeServices: CoacheeService,private platoServices:PlatosService,private  aliimentosServices:AlimentosService) {
  }

  ngOnInit(): void {
    this.coacheeServices.getCoacheeById(this.idcoachee).subscribe({
      next: value => {
        this.coachee = value
      }, error: error => {
        console.log(error)
      }


    })

    this.dietaService.getAllByCoacheeId(this.idcoachee).subscribe({
      next:value => {
        this.dietas=value
      },error:err => {
        console.log(err)
      }
    })    }



  onSelectDieta(dieta:Dieta){
    this.selectedDietaId=dieta.id;
  }

  onSelectPlato(plato:Plato){
    this.selectedPlatoId=plato.id;
  }

  addDieta(){}
  addPlato() {}
  addAlimento(){}
}
