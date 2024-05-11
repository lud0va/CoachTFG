import {PlatoAlimentosElem} from "../platoalimentoselem/platosalimentoselem";

export class Plato{
  id?:number;
  descripcion?:string;
  nombre?:string;
  hora?:string;
  calTotal?:number;
  alimentosPlato?:PlatoAlimentosElem[];

}
