import { Component, OnInit, Input, IterableDiffers } from '@angular/core';
import { DataService } from '../../../data.service';
import { IShow } from '../../../ishow';

import { IMovie } from '../../../imovie';
import { ITicket } from '../../../iticket';
import { ITheatre } from '../../../itheatre';

@Component({
  selector: 'app-seat',
  template: `
    <img height="10px" width="20px" src="{{checkStatus()}}" (click)="dbBook()">
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
  }

  dbBook() {
    const t: ITicket = <ITicket>{};

    t.seatcol = this.colx; // WTF TODO FIX THIS
    t.seatrow = this.coly;
    t.show = this.show;

    this._dataService.postTicket(t).subscribe( ret => {
      console.log('Ticket registered');
      this._dataService.cacheData();
      this.updateColor();
    });

    console.log('book x:' + this.colx + ' y:' + this.coly );
  }

  ngOnInit() {
    // this.updateColor();
  }
}
