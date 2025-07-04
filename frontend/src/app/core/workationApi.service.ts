import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

export interface Workation {
  workationId: string;
  employee: string;
  origin: string;
  destination: string;
  start: string;     // 'dd/MM/yyyy'
  end: string;       // 'dd/MM/yyyy'
  workingDays: number;
  risk: string;
}

@Injectable({
  providedIn: 'root'
})
export class WorkationService {
  private apiUrl = 'http://localhost:8080/workflex/workation';

  constructor(private http: HttpClient) {
  }

  getWorkations(sortBy: string = 'workationId', direction: string = 'asc'): Observable<Workation[]> {
    return this.http.get<Workation[]>(`${this.apiUrl}?sortBy=${sortBy}&direction=${direction}`);
  }

}
