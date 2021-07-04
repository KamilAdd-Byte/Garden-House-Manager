import { TestBed } from '@angular/core/testing';

import { BasilService } from './basil.service';

describe('BasilService', () => {
  let service: BasilService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BasilService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
