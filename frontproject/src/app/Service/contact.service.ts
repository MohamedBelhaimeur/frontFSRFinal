import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ContactService {
  apiUrl: string = environment.url;
  constructor(private http: HttpClient) {}

  getContact(id: number): Observable<any> {
    // now returns an Observable of Config
    return this.http.get(this.apiUrl + id);
  }
}
