import { TestBed } from '@angular/core/testing';

import { LogRegServices } from './log-reg-services.service';

describe('LogRegServicesService', () => {
  let service: LogRegServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LogRegServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
