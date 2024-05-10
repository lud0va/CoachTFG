import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {LogRegServices} from "../../services/login/log-reg-services.service";


@Component({
  selector: 'app-nav',

  templateUrl: './nav.component.html',
  styleUrl: './nav.component.css'
})
export class NavComponent implements OnInit {
  userLoginOn:boolean=false;
  constructor(private loginService:LogRegServices, private router:Router) { }

  ngOnInit(): void {
    this.loginService.currentUserLoginOn.subscribe(
      {
        next:(userLoginOn) => {
          this.userLoginOn=userLoginOn;
        }
      }
    )
  }

  logout()
  {
    this.loginService.logout();
    this.router.navigate(['/inicio'])
  }

}
