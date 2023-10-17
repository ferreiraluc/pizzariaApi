import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BalcaodetailsComponent } from './balcaodetails.component';

describe('BalcaodetailsComponent', () => {
  let component: BalcaodetailsComponent;
  let fixture: ComponentFixture<BalcaodetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BalcaodetailsComponent]
    });
    fixture = TestBed.createComponent(BalcaodetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
