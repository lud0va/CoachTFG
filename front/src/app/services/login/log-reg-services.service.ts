import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {BehaviorSubject, catchError, map, Observable, tap, throwError} from "rxjs";
import {LoginRequest} from "./loginRequest";
import {TokensResp} from "./TokensResp";

const baseUrl= 'http://localhost:8080/login';

@Injectable({
  providedIn: 'root'
})
export class LogRegServices {
  currentUserLoginOn:BehaviorSubject<boolean>=new BehaviorSubject<boolean>(false);
  currentUserData:BehaviorSubject<TokensResp>=new BehaviorSubject<TokensResp>({accessToken:"",refreshToken:""});
  constructor(private  http:HttpClient) {
    this.currentUserLoginOn=new BehaviorSubject<boolean>(sessionStorage.getItem("refreshToken")!=null);
  }
  login(credentials:LoginRequest):Observable<TokensResp>{
    return this.http.get<TokensResp>(`${baseUrl}?email=${credentials.email}&password=${credentials.password}`).pipe(
     tap((userdata:TokensResp)=>{
       sessionStorage.setItem("accessToken",userdata.accessToken)
       sessionStorage.setItem("refreshToken",userdata.refreshToken)

       this.currentUserData.next(userdata)
       this.currentUserLoginOn.next(true)
     }),
      catchError(this.handleError)
    )
  }
  logout():void {
    sessionStorage.removeItem("accessToken")
    sessionStorage.removeItem("refreshToken")
    this.currentUserLoginOn.next(false)

  }


  private handleError(error:HttpErrorResponse){

  return  throwError(()=>new Error('Algo falló XD'))

  }

  get userData():Observable<TokensResp>{
    return this.currentUserData.asObservable();
  }

  get userLoginOn(): Observable<boolean>{
    return this.currentUserLoginOn.asObservable();
  }

  get userToken():TokensResp{
    return this.currentUserData.value;
  }
}
