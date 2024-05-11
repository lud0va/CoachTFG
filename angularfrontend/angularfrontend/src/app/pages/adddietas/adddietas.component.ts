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
import {Alimento} from "../../model/alimento/alimento";
import {PlatoAlimentosElem} from "../../model/platoalimentoselem/platosalimentoselem";

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
  activatedAlimento=true
  activatedPlato=true
  activatedFinalDiet=true
  alimentos?: Alimento[]
  selectedAlimento: Alimento={id:1};
  dietaSend:Dieta={}
  selectPlatosid?:number

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

   this.cargarDieta()
    this.aliimentosServices.getAllAlimentos().subscribe({
      next:value => {
        this.alimentos=value
      },error:err => {
        console.log(err)
      }
    })

  }

  cargarDieta(){
    this.dietaService.getAllByCoacheeId(this.idcoachee).subscribe({
      next:value => {
        this.dietas=value
      },error:err => {
        console.log(err)
      }
    })
  }

  onSelectDieta(dieta:Dieta){
    this.selectedDietaId=dieta.id;
  }

  onSelectPlato(plato:Plato){
    this.selectedPlatoId=plato.id;
  }
  onSelectAlimento(alimento: Alimento): void {
    this.selectedAlimento = alimento;
  }
  onSelectPlatoAdd(plato:Plato):void{
    this.activatedAlimento=false

    this.selectPlatosid=plato.id;
  }
  addDieta(){
    if (this.form.valid) {
      const dietaData = this.form.value;
      const fechaFinDieta = new Date(dietaData.finDieta?? new Date());
      this.dietaSend = {
        idcoachee:this.idcoachee,
        caloriasmaxdia: dietaData.caloriasMaxDia ?? '', // Utilizamos el operador de coalescencia nula para proporcionar un valor predeterminado
        fija: dietaData.fija ?? '', // Igualmente aquí
        finDieta: fechaFinDieta,
        platoDeDieta:[]
      }
    }
    this.activatedPlato=false;
    this.activatedFinalDiet=false;
  }
  addPlato() {
    const platoData = this.formPlato.value;
    const plato:Plato={
      descripcion:platoData.desc??'',
      nombre:platoData.nombre??'',
      hora:platoData.Hora??'',
      calTotal:Number(platoData.calTotal??''),
      alimentosPlato:[]
    }
    this.dietaSend?.platoDeDieta?.push(plato)

  }
  addAlimento(){


        const alimentosPlat:PlatoAlimentosElem={
          alimento:this.selectedAlimento

        }
        this.dietaSend.platoDeDieta?.find(plato => plato.id === this.selectPlatosid)?.alimentosPlato?.push(alimentosPlat)






  }

  addDietaComplete(){

    this.dietaService.addDieta(this.dietaSend).subscribe({
      next:value => {
        this.cargarDieta()
      },error:err => {
        console.log(err)
      }
    })


  }
}
