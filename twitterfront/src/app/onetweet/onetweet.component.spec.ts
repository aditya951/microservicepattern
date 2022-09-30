import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OnetweetComponent } from './onetweet.component';

describe('OnetweetComponent', () => {
  let component: OnetweetComponent;
  let fixture: ComponentFixture<OnetweetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OnetweetComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OnetweetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
