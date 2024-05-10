import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, Observable, tap, throwError} from "rxjs";

import {RegisterRequest} from "./registerRequest";
import {Injectable} from "@angular/core";
const baseUrl= 'http://localhost:8080/registerCoach';

@Injectable({
  providedIn: 'root'
})


export class RegisterService {
  constructor(private  http:HttpClient) {
  }
  register(credentials:RegisterRequest):Observable<Boolean>{
    return this.http.get<Boolean>(`${baseUrl}?email=${credentials.email}&password=${credentials.password}&name=${credentials.nombre}&lastname=${credentials.apellido}`).pipe(

      catchError(this.handleError)
    )
  }
  private handleError(error:HttpErrorResponse){

    return  throwError(()=>new Error('Algo falló XD'))

  }

}
