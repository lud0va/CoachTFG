import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {Observable} from "rxjs";
import {Coachlistparam} from "./coachlistparam";
const baseUrl= 'http://localhost:8081/coachee';

@Injectable({
  providedIn: 'root'
})
export class CoacheeService {

  constructor(private http:HttpClient) { }

  getAllByCoach(id:number):Observable<Coachee[]>{
    return this.http.get<Coachee[]>(`${baseUrl}/getAllByCoach?idCoach=${id}`)
  }
  getCoacheeById(id:number):Observable<Coachee>{
    return this.http.get<Coachee>(`${baseUrl}/get?id=${id}`)
  }
}
