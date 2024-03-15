import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewComidasComponent } from './view-comidas.component';

describe('ViewComidasComponent', () => {
  let component: ViewComidasComponent;
  let fixture: ComponentFixture<ViewComidasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewComidasComponent]
    });
    fixture = TestBed.createComponent(ViewComidasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
