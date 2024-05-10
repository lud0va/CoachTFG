import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoacheedetailComponent } from './coacheedetail.component';

describe('CoacheedetailComponent', () => {
  let component: CoacheedetailComponent;
  let fixture: ComponentFixture<CoacheedetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CoacheedetailComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CoacheedetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
