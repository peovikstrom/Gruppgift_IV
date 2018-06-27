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

  public movie: IMovie[] = [{
    id: 0,
    title: 'unknown',
    desc: 'unknown',
    uri: 'unknown',
  }];

  postResponse = 'POSTRESP';

  testmov: IMovie = {
    id: 1,
    title: 'My Little Pony',
    desc: 'Friendship is Magic',
    uri: 'https://i.pinimg.com/736x/1a/d9/d4/1ad9d4743e0fe8ec589469c35e2cd294.jpg'
};

  constructor(private _dataService: DataService) { }

  postIT() {
    this._dataService.postMovie( this.testmov )
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
