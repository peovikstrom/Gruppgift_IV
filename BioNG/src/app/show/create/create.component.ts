import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../../data.service';
import { IMovie } from '../../imovie';
import { ITheatre } from '../../itheatre';
import { ActivatedRoute } from '@angular/router';
import { IShow } from '../../ishow';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  public movies: IMovie[];
  public theatres: ITheatre[];
  public shows: IShow[];

  constructor(private _dataService: DataService,
    private _route: ActivatedRoute) { }

  ngOnInit() {
  }

  myTheatres() {
    return this._dataService.getCachedTheatres();
  }

  myMovies() {
    return this._dataService.getCachedMovies();
  }

}
