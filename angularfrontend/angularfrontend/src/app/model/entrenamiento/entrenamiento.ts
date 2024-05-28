import {Ejercicio} from "../ejercicio/ejercicio";
import {Coachee} from "../coacheelistmodel/coachee";

export class Entrenamiento{
  id?:number;
  diaSemana?:string;
  tipo?:string;
  ejercicios?:Ejercicio[];
  coachee?:Coachee;

}
