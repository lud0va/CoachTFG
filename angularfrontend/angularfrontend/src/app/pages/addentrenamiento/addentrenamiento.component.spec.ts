import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddentrenamientoComponent } from './addentrenamiento.component';

describe('AddentrenamientoComponent', () => {
  let component: AddentrenamientoComponent;
  let fixture: ComponentFixture<AddentrenamientoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AddentrenamientoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AddentrenamientoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
