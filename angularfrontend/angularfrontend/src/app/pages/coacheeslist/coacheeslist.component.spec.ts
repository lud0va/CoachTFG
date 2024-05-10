import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoacheeslistComponent } from './coacheeslist.component';

describe('CoacheeslistComponent', () => {
  let component: CoacheeslistComponent;
  let fixture: ComponentFixture<CoacheeslistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CoacheeslistComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CoacheeslistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
