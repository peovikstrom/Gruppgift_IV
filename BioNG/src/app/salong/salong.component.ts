import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IShow } from '../ishow';
import { ActivatedRoute } from '@angular/router';
import { ITheatre } from '../itheatre';

@Component({
  selector: 'app-salong',
  templateUrl: './salong.component.html',
  styleUrls: ['./salong.component.css']
})
export class SalongComponent implements OnInit {

  public httpBase = 'http://localhost:8080/';

  public salNum = 'Ett';
  public greeting = '';

  public shows: IShow[];
  public jsonTest = '';

  constructor(
    private _dataService: DataService,
    private _route: ActivatedRoute
    ) { }


  myTheatre() {
    return this._dataService.getCachedTheatres()[this.getID()];
  }


  // show4theatre(theatre: ITheatre) {
  myShows() {
    return this._dataService.show4theatre(this.myTheatre());
  }


  getID() {
    return parseInt(this._route.snapshot.paramMap.get('id'), 10);
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
