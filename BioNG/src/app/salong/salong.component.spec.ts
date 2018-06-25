import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SalongComponent } from './salong.component';

describe('SalongComponent', () => {
  let component: SalongComponent;
  let fixture: ComponentFixture<SalongComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SalongComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SalongComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
