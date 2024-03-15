import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateComidasComponent } from './update-comidas.component';

describe('UpdateComidasComponent', () => {
  let component: UpdateComidasComponent;
  let fixture: ComponentFixture<UpdateComidasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateComidasComponent]
    });
    fixture = TestBed.createComponent(UpdateComidasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
