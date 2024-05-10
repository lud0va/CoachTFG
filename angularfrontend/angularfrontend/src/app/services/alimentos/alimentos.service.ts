import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ejercicio} from "../../model/ejercicio/ejercicio";
import {Observable} from "rxjs";
import {Alimento} from "../../model/alimento/alimento";
const baseUrl= 'http://localhost:8081/alimentos';

@Injectable({
  providedIn: 'root'
})
export class AlimentosService {

  constructor(private http:HttpClient) { }
  addAlimentosPlato(idplato:number,alimentos:Alimento): Observable<Ejercicio> {
    return this.http.post<Ejercicio>(`${baseUrl}?idplato=${idplato}`, alimentos);
  }

  addAlimentosDieta(iddieta:number,alimentos:Alimento): Observable<Ejercicio> {
    return this.http.post<Ejercicio>(`${baseUrl}?iddieta=${iddieta}`, alimentos);
  }
}
