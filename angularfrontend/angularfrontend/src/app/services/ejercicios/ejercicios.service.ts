import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Entrenamiento} from "../../model/entrenamiento/entrenamiento";
import {Observable} from "rxjs";
import {Ejercicio} from "../../model/ejercicio/ejercicio";
const baseUrl= 'http://localhost:8081/ejercicios';

@Injectable({
  providedIn: 'root'
})
export class EjerciciosService {

  constructor(private http:HttpClient) { }
  addEjercicio(ejercicio: Ejercicio): Observable<Ejercicio> {
    return this.http.post<Ejercicio>(`${baseUrl}`, ejercicio);
  }
}
