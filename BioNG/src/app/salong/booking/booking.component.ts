import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../../data.service';
import { IShow } from '../../ishow';
import { ITicket } from '../../iticket';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  @Input() show: IShow;

  tags = [];

  constructor(
    private _dataService: DataService
  ) { }

  doTags(x, y) {
    this.tags = [{
      x: x,
      y: y
    }];
  }

  xrange(cnt): number[] {
    const a = [];
    for (let i = 0; i < cnt; i++) {
      a.push(i);
    }
    return a;
  }

  dbBook(colx: number, rowy: number) {
    const t: ITicket = <ITicket>{}; // A Cheat ticket

    let t4s = this._dataService.tickets4show(this.show);
    t4s = t4s.filter( ts => ts.seatcol === colx && ts.seatrow === rowy);

    t.seatcol = colx;
    t.seatrow = rowy;
    t.show = this.show;

    if ( t4s.length === 0 ) {

      this._dataService.postTicket([t]).subscribe( ret => {
        this._dataService.pushGlobTickets(ret);
        // this.checkStatus(); // We got new tickets update colors
      });

    } else {

      t.id = t4s[0].id;

      this._dataService.postUnTicket([t]).subscribe( ret => {
        this._dataService.pushGlobTickets(ret);
        // this.checkStatus(); // We got new tickets update colors
      });

    }
    console.log('book x:' + colx + ' y:' + rowy );
  }

  ngOnInit() {
  }

}
