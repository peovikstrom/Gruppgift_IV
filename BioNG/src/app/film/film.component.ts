import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IMovie } from '../imovie';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {

  public movie: IMovie[] = [];

  postResponse = 'POSTRESP';

  constructor(private _dataService: DataService) { }

  postIT() {
    console.log("POSTIT");
    this._dataService.postMovie()
      .subscribe( (data: any) => {
        this.postResponse = data.ret;
        console.log(data);
      });
  }

  ngOnInit() {
    this._dataService.getAllMovies()
      .subscribe(data => this.movie = data);
  }

}
