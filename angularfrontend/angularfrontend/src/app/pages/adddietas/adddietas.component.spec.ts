import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdddietasComponent } from './adddietas.component';

describe('AdddietasComponent', () => {
  let component: AdddietasComponent;
  let fixture: ComponentFixture<AdddietasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AdddietasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdddietasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
