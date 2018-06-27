import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IMovie } from './imovie';
import { IShow } from './ishow';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  baseUrl = '';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  testmov: IMovie = {
      id: 1,
      title: 'My Little Pony',
      desc: 'Friendship is Magic',
      uri: 'https://i.pinimg.com/736x/1a/d9/d4/1ad9d4743e0fe8ec589469c35e2cd294.jpg'
  };


  constructor(private _http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/test';
  }

  getTest() {
    return this._http.get(this.baseUrl);
  }

  getAllMovies(): Observable<IMovie[]> {
    return this._http.get<IMovie[]>('http://localhost:8080/api/allmovies');
  }

  getAllShows(): Observable<IShow[]> {
    return this._http.get<IShow[]>('http://localhost:8080/api/allshows');
  }

  postMovie() {
    return this._http.post<string>('http://localhost:8080/api/postmovie', this.testmov, this.httpOptions);
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
