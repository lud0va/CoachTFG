import { Component } from '@angular/core';
import {Coach} from "../model/coach";
import {CoachService} from "../services/coach/coach.service";

@Component({
  selector: 'app-coach-list',
  standalone: true,
  imports: [],
  templateUrl: './coach-list.component.html',
  styleUrl: './coach-list.component.css'
})
export class CoachListComponent {
  coachs?:Coach[];
  constructor(private coachService:CoachService) {
  }
  ngOnInit():void{
    this.fetchCoach()
  }
  private fetchCoach(){
    this.coachService.getAll().subscribe({
        next: value=>{
          this.coachs = value
          console.log(value)
        },error:error=>{console.log(error)}
    }

    )
  }
}
