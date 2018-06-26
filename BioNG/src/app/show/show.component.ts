import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  public shows = [];

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    this.shows = this._dataService.getShows();
  }

}
