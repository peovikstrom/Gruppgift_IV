import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';
import { ITheatre } from './itheatre';
import { Router } from '@angular/router';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {

  title = 'BioNG';
  theatres: ITheatre[] = [];

  constructor(
    private _dataService: DataService,
    private _router: Router
  ) { }

  onSelect(sal) {

    console.log(sal);
    this._router.navigate(['/salong', sal]);
  }

  ngOnInit() {
    this._dataService.getAllTheatres().subscribe(t => {
      this.theatres = t;
    });
  }

}
