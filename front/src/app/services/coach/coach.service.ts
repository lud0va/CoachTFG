import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Coach} from "../../model/coach";
const baseUrl= 'http://localhost:8081/coach';
@Injectable({
  providedIn: 'root'
})
export class CoachService {

  constructor(private http:HttpClient) { }

  getAll():Observable<Coach[]>{
    return this.http.get<Coach[]>(`${baseUrl}`)
  }
  getCoach(id:number):Observable<Coach>{
    return this.http.get(`${baseUrl}/getCaoach?${id}`)
  }

}
