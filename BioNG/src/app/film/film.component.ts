import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IMovie } from '../imovie';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  public movie: IMovie[] = [];

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    this._dataService.getAllMovies()
      .subscribe(data => this.movie = data);
  }

}
