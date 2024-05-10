import {Component, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../../services/login/login.service";
import {RegisterService} from "../../services/register/register.service";
import {LoginRequest} from "../../services/login/loginRequest";
import {RegisterRequest} from "../../services/register/registerRequest";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent  implements OnInit{
  form=this.formBuilder.group({
    email:['',[Validators.required,Validators.email]],
    password:['',Validators.required],
    nombre:['',Validators.required],
    apellido:['',Validators.required]
  })
  constructor(private formBuilder:FormBuilder,private router:Router,private  registerServ:RegisterService) {
  }
  get email(){
    return this.form.controls.email
  }
  get password(){
    return this.form.controls.password
  }
  get nombre(){
    return this.form.controls.nombre
  }
  get apellido(){
    return this.form.controls.apellido
  }
  register(){
    if(this.form.valid){
      this.loginError="";
      this.registerServ.register(this.form.value as RegisterRequest).subscribe({
        next: (userData) => {
          console.log(userData);
        },
        error: (errorData) => {
          console.error(errorData);
          this.loginError=errorData;
        },
        complete: () => {
          alert("register completo.");
          console.info("register completo");
          this.router.navigateByUrl('/inicio');
          this.form.reset();
        }
      })

    }
    else{
      this.form.markAllAsTouched();
      alert("Error al ingresar los datos.");
    }
  }
  loginError:string=""
    ngOnInit(): void {

    }

}
