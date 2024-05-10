import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Dieta} from "../../model/dieta/dieta";
import {Entrenamiento} from "../../model/entrenamiento/entrenamiento";
const baseUrl= 'http://localhost:8081/entrenamientos';

@Injectable({
  providedIn: 'root'
})
export class EntrenamientosService {

  constructor(private http:HttpClient) { }
  getAllByCoacheeId(id:number):Observable<Entrenamiento[]>{
    return this.http.get<Entrenamiento[]>(`${baseUrl}?id=${id}`)
  }
  addEntrenamiento(entrenamiento: Entrenamiento): Observable<Entrenamiento> {
    return this.http.post<Entrenamiento>(`${baseUrl}`, entrenamiento);
  }
}
