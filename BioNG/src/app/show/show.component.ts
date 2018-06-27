import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IShow } from '../ishow';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  public shows: IShow[];
  public test;

  public foo = {
    showId: 1,
    movieId: 2
  };

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    // this._dataService.getTest();
    this._dataService.getAllShows().subscribe(data => this.shows = data);
  }

}
