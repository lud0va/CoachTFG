import {Plato} from "../plato/plato";
import {Alimento} from "../alimento/alimento";

export class Dieta{
  id?:number;
  caloriasmaxdia?:string;
  fija?:string;
  finDieta?:Date;
  platoDeDieta?:Plato[];
  alimentosPermitidos?:Alimento[];

}
