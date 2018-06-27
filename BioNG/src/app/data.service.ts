import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { Observable, observable } from '../../node_modules/rxjs';
import {Observable} from 'rxjs';

import { IMovie } from './imovie';
import { IShow } from './ishow';
import { HttpRequest } from '../../node_modules/@types/selenium-webdriver/http';

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

  handleError() {
    console.log('HANDLE ERROR');
  }

  postMovie() {

    let foo = null;

    console.log('DataService postMovie');
    console.log(JSON.stringify(this.testmov));
    // foo = this._http.post<IMovie>('http://localhost:8080/api/posttest', JSON.stringify(this.testmov), this.httpOptions);

    foo = this._http.post<IMovie>('http://localhost:8080/api/posttest', this.testmov, this.httpOptions)
      .toPromise()
      .catch(this.handleError);


    // .pipe(tap((hero: Hero) => this.log(`added hero w/ id=${hero.id}`)),catchError(this.handleError<Hero>('addHero'))

    console.log(foo);
    return foo;
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
