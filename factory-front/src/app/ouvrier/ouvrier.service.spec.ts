import { TestBed } from '@angular/core/testing';

import { OuvrierService } from './ouvrier.service';

describe('OuvrierService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OuvrierService = TestBed.get(OuvrierService);
    expect(service).toBeTruthy();
  });
});
