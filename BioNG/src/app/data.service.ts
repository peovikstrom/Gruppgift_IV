import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IMovie } from './imovie';
import { IShow } from './ishow';
import { ITicket } from './iticket';
import { ITheatre } from './itheatre';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  baseUrl = '';

  tickets: ITicket[] = [];

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private _http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/';
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

  getAllTickets(): Observable<ITicket[]> {
    return this._http.get<ITicket[]>('http://localhost:8080/api/alltickets');
  }

  getAllTheatres(): Observable<ITheatre[]> {
    return this._http.get<ITheatre[]>('http://localhost:8080/api/alltheatre');
  }

  postMovie(movie: IMovie) {
    return this._http.post<string>('http://localhost:8080/api/postmovie', movie, this.httpOptions);
  }

  postShow(show: IShow) {
    return this._http.post<string>('http://localhost:8080/api/postshow', show, this.httpOptions);
  }

  postTicket(ticket: ITicket) {
    return this._http.post<string>('http://localhost:8080/api/postticket', ticket, this.httpOptions);
  }

  cacheTickets() {
    this._http.get<ITicket[]>('http://localhost:8080/api/alltickets').subscribe( tickets => {
      this.tickets = tickets;
    });

  }

  tickets4show(show: IShow) {
    if ( this.tickets === [] ) {
      return [];
    }

    return this.tickets.filter( t => {
      return (t.show === show);
    });
  }

}
