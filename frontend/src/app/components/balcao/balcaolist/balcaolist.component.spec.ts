import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BalcaolistComponent } from './balcaolist.component';

describe('BalcaolistComponent', () => {
  let component: BalcaolistComponent;
  let fixture: ComponentFixture<BalcaolistComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BalcaolistComponent]
    });
    fixture = TestBed.createComponent(BalcaolistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
