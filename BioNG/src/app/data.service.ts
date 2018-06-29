import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IMovie } from './imovie';
import { IShow } from './ishow';
import { ITicket } from './iticket';
import { IGreyTicket } from './igreyticket';
import { ITheatre } from './itheatre';
import { tick } from '../../node_modules/@angular/core/testing';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  baseUrl = '';

  tickets: ITicket[] = [];
  shows: IShow[] = [];
  theatres: ITheatre[] = [];
  movies: IMovie[] = [];

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private _http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/';
  }
  getCachedMovies(): IMovie[] { return this.movies; }
  getAllMovies(): Observable<IMovie[]> {
    return this._http.get<IMovie[]>('http://localhost:8080/api/allmovies');
  }
  getCachedShows(): IShow[] { return this.shows; }
  getAllShows(): Observable<IShow[]> {
    return this._http.get<IShow[]>('http://localhost:8080/api/allshows');
  }
  getCachedTickets(): ITicket[] { return this.tickets; }
  getAllTickets(): Observable<ITicket[]> {
    return this._http.get<ITicket[]>('http://localhost:8080/api/alltickets');
  }
  getCachedTheatres(): ITheatre[] { return this.theatres; }
  getAllTheatres(): Observable<ITheatre[]> {
    return this._http.get<ITheatre[]>('http://localhost:8080/api/alltheatre');
  }

  postMovie(movie: IMovie) {
    return this._http.post<string>('http://localhost:8080/api/postmovie', movie, this.httpOptions);
  }

  postShow(show: IShow) {
    return this._http.post<string>('http://localhost:8080/api/postshow', show, this.httpOptions);
  }

  postTicket(ticket: IGreyTicket) {
    // this.tickets.push(ticket);
    console.log(ticket);
    return this._http.post<string>('http://localhost:8080/api/postticket', ticket, this.httpOptions);
  }

  cacheData() {
    this._http.get<ITicket[]>('http://localhost:8080/api/alltickets').subscribe( tickets => { this.tickets = tickets; });
    this._http.get<ITheatre[]>('http://localhost:8080/api/alltheatre').subscribe( theatres => { this.theatres = theatres; });
    this._http.get<IShow[]>('http://localhost:8080/api/allshows').subscribe( shows => { this.shows = shows; });
    this._http.get<IMovie[]>('http://localhost:8080/api/allmovies').subscribe( movies => { this.movies = movies; });
  }


  tickets4show(show: IShow) {
    if ( this.tickets === [] ) {
      return [];
    }
    return this.tickets.filter( t => t.show.id === show.id );
  }


  show4theatre(theatre: ITheatre) {
    if ( this.shows === [] ) {
      return [];
    }
    return this.shows.filter( s => s.theatre.id === theatre.id);
  }

}
