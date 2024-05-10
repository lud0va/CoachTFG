import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../../services/login/login.service";
import {LoginRequest} from "../../services/login/loginRequest";
import {UserService} from "../../services/user/user.service";
import {User} from "../../model/user/user";
import {Userparam} from "../../services/login/userparam";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  form=this.formBuilder.group({
    email:['',[Validators.required,Validators.email]],
    password:['',Validators.required]
  })
  user?:User;

  constructor(private formBuilder:FormBuilder,private router:Router,private loginService:LoginService,private  userService:UserService) {
   }
   get email(){
    return this.form.controls.email
   }
  get password(){
    return this.form.controls.password
  }
  loginError:string=""
  login(){
    this.loadUser();

    if(this.form.valid){
      this.loginError="";
      this.loginService.login(this.form.value as LoginRequest).subscribe({
        next: (userData) => {
          console.log(userData);
        },
        error: (errorData) => {
          console.error(errorData);
          this.loginError=errorData;
        },
        complete: () => {
          console.info("Login completo");
          this.router.navigateByUrl('/coacheelist');
          this.form.reset();
        }
      })

    }
    else{
      this.form.markAllAsTouched();
      alert("Error al ingresar los datos.");
    }
  }

  loadUser():void
  {
    this.userService.getUserByEmail(this.form.value as Userparam).subscribe({
      next:(data)=>{
        sessionStorage.setItem("currentUserId",data.id.toString())
        sessionStorage.setItem("currentUserEmail",data.email)

      }
    })

  }
    ngOnInit(): void {
          }

}
