import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  public shows = [];
  public test;

  public foo = {
    showId: 1,
    movieId: 2
  };

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    this.shows = this._dataService.getShows();
    this.test = this._dataService.getTest();
  }

}
