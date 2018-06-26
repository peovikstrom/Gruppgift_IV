import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor() { }

  getShows() {
    return [
      {
        showId: 1,
        movieId: 2
      }
    ];
  }
}
