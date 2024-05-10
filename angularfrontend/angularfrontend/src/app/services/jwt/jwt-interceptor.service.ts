import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoginService} from "../login/login.service";

@Injectable({
  providedIn: 'root'
})
export class JwtInterceptorService implements HttpInterceptor {
  constructor(private loginService:LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let Accesstoken:String=this.loginService.userToken.access_token;

    if (Accesstoken!=""){
      if (req.url.includes("8081")) {
        req=req.clone(
          {
            setHeaders: {
              'Content-Type': 'application/json; charset=utf-8',
              'Accept': 'application/json',
              'Authorization': `Bearer ${Accesstoken}`,
            },
          }
        );
      }
      }
    return next.handle(req);
  }
}
