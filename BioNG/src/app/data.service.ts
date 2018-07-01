import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IMovie } from './imovie';
import { IShow } from './ishow';
import { ITicket } from './iticket';
import { ITicketSTUB } from './iticketstub';
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


  // ------------- Movies
  // Update the local movie array
  pushGlobMovie(movies: IMovie[]) {
    this.movies = movies;
  }
  getCachedMovies(): IMovie[] { return this.movies; }
  getAllMovies(): Observable<IMovie[]> {
    return this._http.get<IMovie[]>('http://localhost:8080/api/allmovies');
  }

  // Update the remove movie db from local
  postMovie(movie: IMovie) {
    return this._http.post<string>('http://localhost:8080/api/postmovie', movie, this.httpOptions);
  }


  // ------------- Shows
  // Update the local movie array
  pushGlobShows(shows: IShow[]) {
    this.shows = shows;
  }
  getCachedShows(): IShow[] { return this.shows; }
  getAllShows(): Observable<IShow[]> {
    return this._http.get<IShow[]>('http://localhost:8080/api/allshows');
  }
  postShow(show: IShow) {
    return this._http.post<string>('http://localhost:8080/api/postshow', show, this.httpOptions);
  }


  // ------------- Tickets
  // Update the local ticket array
  pushGlobTickets(tickets: ITicket[]) {
    this.tickets = tickets;
  }
  getCachedTickets(): ITicket[] { return this.tickets; }
  getAllTickets(): Observable<ITicket[]> {
    return this._http.get<ITicket[]>('http://localhost:8080/api/alltickets');
  }

  postTicket(tickets: ITicket[]) {

    const tstubs = [];

    for (const t of tickets ) {
    const stubTicket = <ITicketSTUB>{};
      // stubTicket.ticketid = t.id;
      stubTicket.seatcol = t.seatcol;
      stubTicket.seatrow = t.seatrow;
      stubTicket.showid = t.show.id;

      tstubs.push(stubTicket);
    }

    // Causes concurency issues
    // this.tickets.push(ticket);

    return this._http.post<ITicket[]>('http://localhost:8080/api/postticket', tstubs, this.httpOptions);
  }

  postUnTicket(tickets: ITicket[]) {

    const tstubs = [];

    for (const t of tickets ) {
    const stubTicket = <ITicketSTUB>{};
      stubTicket.ticketid = t.id;
      stubTicket.seatcol = t.seatcol;
      stubTicket.seatrow = t.seatrow;
      stubTicket.showid = t.show.id;

      tstubs.push(stubTicket);
  }

    // Causes concurency issues
    // this.tickets = this.tickets.filter( tr => tr.id !== ticket.id );

    return this._http.post<ITicket[]>('http://localhost:8080/api/postunticket', tstubs, this.httpOptions);
  }


  // ------------- Theatres / Salongs
  getCachedTheatres(): ITheatre[] { return this.theatres; }
  getAllTheatres(): Observable<ITheatre[]> {
    return this._http.get<ITheatre[]>('http://localhost:8080/api/alltheatre');
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
