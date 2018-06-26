import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from '../../node_modules/rxjs';
import { IMovie } from './imovie';
import { IShow } from './ishow';

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

  getMovie(): Observable<IMovie> {
    return this._http.get<IMovie>(this.baseUrl);
  }

  getAllShows(): Observable<IShow[]> {
    return this._http.get<IShow[]>('http://localhost:8080/api/allshows');
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
