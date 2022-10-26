import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ContactService {
  apiUrl: string = environment.url;

  constructor(private http: HttpClient) {}

  getContact(id: Number): Observable<any> {
    return this.http.get(this.apiUrl + id);
  }
  postContact(c: any): Observable<any> {
    return this.http.post(this.apiUrl, c);
  }

  putContact(c: any, id: number): Observable<any> {
    return this.http.put(this.apiUrl + id, c);
  }

  deleteContact(id: number): Observable<any> {
    return this.http.delete(this.apiUrl + id);
  }
}
