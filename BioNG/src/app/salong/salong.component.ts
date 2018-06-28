import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { IShow } from '../ishow';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-salong',
  templateUrl: './salong.component.html',
  styleUrls: ['./salong.component.css']
})
export class SalongComponent implements OnInit {
  public componentId = 0;

  public salNum = 'Ett';
  public greeting = '';

  public shows: IShow[];
  public jsonTest = '';

  constructor(
    private _dataService: DataService,
    private _route: ActivatedRoute
    ) { }

  ngOnInit() {
    this._dataService.getAllShows()
    .subscribe( data => {
      this.shows = data;
      this.jsonTest = JSON.stringify(data);
    });

    this.componentId = parseInt(this._route.snapshot.paramMap.get('id'), 10);

    console.log('Salong init');

  }

  onClick() {
    console.log('Welcome!');
    this.greeting = 'Welcome!';
  }

}
