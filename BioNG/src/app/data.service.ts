import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  baseUrl = '';

  constructor(private _http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/test';
  }

  getTest() {
    return this._http.get(this.baseUrl);
  }

  getShows() {
    return [
      {
        showId: 1,
        movieId: 2
      }
    ];
  }
}
