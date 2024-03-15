import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIngredienteComidaComponent } from './add-ingrediente-comida.component';

describe('AddIngredienteComidaComponent', () => {
  let component: AddIngredienteComidaComponent;
  let fixture: ComponentFixture<AddIngredienteComidaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddIngredienteComidaComponent]
    });
    fixture = TestBed.createComponent(AddIngredienteComidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
