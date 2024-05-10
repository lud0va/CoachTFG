import {Component, OnInit} from '@angular/core';
import {Coachee} from "../../model/coacheelistmodel/coachee";
import {CoacheeService} from "../../services/coachee/coachee.service";
import {UserService} from "../../services/user/user.service";
import {Coachlistparam} from "../../services/coachee/coachlistparam";
import {Router} from "@angular/router";

@Component({
  selector: 'app-coacheeslist',
  templateUrl: './coacheeslist.component.html',
  styleUrl: './coacheeslist.component.css'
})

export class CoacheeslistComponent  implements OnInit{

  constructor(private router:Router,private coacheeServices:CoacheeService,private  userService:UserService) {
  }

  selectedcoachee?:Coachee;

  coachees?:Coachee[];

  ngOnInit():void{
    this.fetchCoach()
  }
  onSelect(coachee:Coachee){
    this.selectedcoachee=coachee
    this.router.navigate(['coachee',coachee.idcoachee]);


  }
  private fetchCoach(){

    this.coacheeServices.getAllByCoach( Number( sessionStorage.getItem("currentUserId"))).subscribe({
        next: value=>{
          this.coachees = value
        },error:error=>{console.log(error)}
      }

    )
  }


}
