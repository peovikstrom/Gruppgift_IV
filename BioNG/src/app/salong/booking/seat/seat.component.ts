import { Component, OnInit, Input, IterableDiffers } from '@angular/core';
import { DataService } from '../../../data.service';
import { IShow } from '../../../ishow';
import { interval } from 'rxjs';

import { IMovie } from '../../../imovie';
import { ITheatre } from '../../../itheatre';
import { ITicketSTUB } from '../../../iticketstub';

@Component({
  selector: 'app-seat',
  template: `
    <img height="10px" width="20px" src="{{checkStatus()}}">
   `,
  styleUrls: ['./seat.component.css']
})

export class SeatComponent implements OnInit {

  private base = 'http://localhost:8080';
  private redSeat = '/img/red.jpg';
  private greenSeat = '/img/green.jpg';
  private blueSeat = '/img/blue.jpg';

  private status = this.base + this.blueSeat;

  @Input() colx: number;
  @Input() coly: number;
  @Input() show: IShow;
  @Input() tags;

  constructor(
    private _dataService: DataService
  ) { }

  checkStatus() {
    this.updateColor();
    return this.status;
  }

  updateColor() {

    let t4s = this._dataService.tickets4show(this.show);
    t4s = t4s.filter( t => t.seatcol === this.colx && t.seatrow === this.coly);
    if ( t4s.length !== 0 ) {
      this.status = this.base + this.redSeat;
    } else {
      this.status = this.base + this.greenSeat;
    }

    // Make "tagged" cells blue
    const tagme = this.tags.filter( tag => tag.x === this.colx && tag.y === this.coly );

    if ( tagme.length !== 0 ) {
      this.status = this.base + this.blueSeat;
    }

  }

  ngOnInit() {
    interval(150).subscribe( x => {
      this.updateColor();
    });
  }
}
