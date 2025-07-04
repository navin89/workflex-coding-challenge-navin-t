import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { WorkationService } from './workationApi.service';

describe('WorkationService', () => {
  let service: WorkationService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [WorkationService]
    });
    service = TestBed.inject(WorkationService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch workations from API', () => {
    const mockData = [
      {
        workationId: 'w5',
        employee: 'Test User',
        origin: 'Germany',
        destination: 'Spain',
        start: '01/01/2024',
        end: '07/01/2024',
        workingDays: 5,
        risk: 'NO'
      }
    ];

    service.getWorkations('employee', 'asc').subscribe(data => {
      expect(data.length).toBe(1);
      expect(data[0].employee).toBe('Test User');
    });

    const req = httpMock.expectOne('http://localhost:8080/workflex/workation?sortBy=employee&direction=asc');
    expect(req.request.method).toBe('GET');
    req.flush(mockData);
  });

  afterEach(() => {
    httpMock.verify();
  });
});
