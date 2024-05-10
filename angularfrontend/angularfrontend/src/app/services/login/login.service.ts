import { Injectable } from '@angular/core';
import {BehaviorSubject, catchError, Observable, tap, throwError} from "rxjs";
import {TokensResp} from "./TokensResp";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {LoginRequest} from "./loginRequest";
const baseUrl= 'http://localhost:8080/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  currentUserLoginOn:BehaviorSubject<boolean>=new BehaviorSubject<boolean>(false);
  currentUserData:BehaviorSubject<TokensResp>=new BehaviorSubject<TokensResp>({access_token:"",refresh_token:""});
  constructor(private  http:HttpClient) {
  }
  login(credentials:LoginRequest):Observable<TokensResp>{
    return this.http.get<TokensResp>(`${baseUrl}?email=${credentials.email}&password=${credentials.password}`).pipe(
      tap((userdata:TokensResp)=>{
        sessionStorage.setItem("access_token",userdata.access_token)
        sessionStorage.setItem("access_token",userdata.refresh_token)
        this.currentUserData.next(userdata)
        this.currentUserLoginOn.next(true)
      }),
      catchError(this.handleError)
    )
  }


  private handleError(error:HttpErrorResponse){

    return  throwError(()=>new Error(error.message))

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
