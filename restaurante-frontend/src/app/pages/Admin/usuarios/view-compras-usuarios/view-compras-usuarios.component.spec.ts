import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewComprasUsuariosComponent } from './view-compras-usuarios.component';

describe('ViewComprasUsuariosComponent', () => {
  let component: ViewComprasUsuariosComponent;
  let fixture: ComponentFixture<ViewComprasUsuariosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewComprasUsuariosComponent]
    });
    fixture = TestBed.createComponent(ViewComprasUsuariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
