import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HerbComponent } from './herb.component';

describe('HerbComponent', () => {
  let component: HerbComponent;
  let fixture: ComponentFixture<HerbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HerbComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HerbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
