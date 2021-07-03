import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BasilComponent } from './basil.component';

describe('BasilComponent', () => {
  let component: BasilComponent;
  let fixture: ComponentFixture<BasilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BasilComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BasilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
