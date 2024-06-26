import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Ejercicio} from "../../model/ejercicio/ejercicio";
import {Observable} from "rxjs";
import {Alimento} from "../../model/alimento/alimento";
const baseUrl= 'http://localhost:8081/alimento';

@Injectable({
  providedIn: 'root'
})
export class AlimentosService {

  constructor(private http:HttpClient) { }
  getAllAlimentos(): Observable<Alimento[]> {
    return this.http.get<Alimento[]>(`${baseUrl}`);
  }


}
