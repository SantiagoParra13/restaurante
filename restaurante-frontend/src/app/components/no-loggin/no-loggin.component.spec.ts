import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NoLogginComponent } from './no-loggin.component';

describe('NoLogginComponent', () => {
  let component: NoLogginComponent;
  let fixture: ComponentFixture<NoLogginComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NoLogginComponent]
    });
    fixture = TestBed.createComponent(NoLogginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
