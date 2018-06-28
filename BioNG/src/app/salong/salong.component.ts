import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IShow } from '../ishow';

@Component({
  selector: 'app-salong',
  templateUrl: './salong.component.html',
  styleUrls: ['./salong.component.css']
})
export class SalongComponent implements OnInit {
  public salNum = 'Ett';
  public greeting = '';

  public shows: IShow[];
  public jsonTest = '';

  constructor(private _dataService: DataService) { }

  firstshow() {
    return this.shows[0];
  }

  ngOnInit() {
    this._dataService.getAllShows()
    .subscribe( data => {
      this.shows = data;
      this.jsonTest = JSON.stringify(data);
    });
  }

  onClick() {
    console.log('Welcome!');
    this.greeting = 'Welcome!';
  }

}
