import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {Dieta} from "../../model/dieta/dieta";
import * as http from "http";
const baseUrl= 'http://localhost:8081/dietas';

@Injectable({
  providedIn: 'root'
})
export class DietasService {

  constructor(private http:HttpClient) { }
  getAllByCoacheeId(id:number):Observable<Dieta[]>{
    return this.http.get<Dieta[]>(`${baseUrl}?id=${id}`)
  }
  addDieta(dieta:Dieta):Observable<Dieta>{
    return this.http.post<Dieta>(`${baseUrl}`,dieta)
  }
}
