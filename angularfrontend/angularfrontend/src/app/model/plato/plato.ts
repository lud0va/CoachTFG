import {Alimento} from "../alimento/alimento";

export class Plato{
  id?:number;
  desc?:string;
  nombre?:string;
  hora?:string;
  calTotal?:number;
  alimentosPlato?:Alimento[];

}
