import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Alimento} from "../../model/alimento/alimento";
import {Observable} from "rxjs";
import {Ejercicio} from "../../model/ejercicio/ejercicio";
import {Dieta} from "../../model/dieta/dieta";
const baseUrl= 'http://localhost:8081/alimentos';

@Injectable({
  providedIn: 'root'
})
export class PlatosService {

  constructor(private http:HttpClient) { }
  addPlatoDieta(iddieta:number,dieta:Dieta): Observable<Ejercicio> {
    return this.http.post<Ejercicio>(`${baseUrl}?iddieta=${iddieta}`, dieta);
  }

}
