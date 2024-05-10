import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {User} from "../../model/user/user";
import {Userparam} from "../login/userparam";
const baseUrl= 'http://localhost:8080/getUserByEmail';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private  http:HttpClient) {
  }






  getUserByEmail(userparam:Userparam):Observable<User>{
    return this.http.get<User>(`http://localhost:8080/getUserByEmail?email=${userparam.email}`)
  }

}
