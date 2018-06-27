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
  public jsonTest = '';

  constructor(private _dataService: DataService) { }

  ngOnInit() {
    this._dataService.getAllShows()
      .subscribe( (data: string) => {
        this.shows = data;
        this.jsonTest = JSON.stringify(data);
      });
  }
}
