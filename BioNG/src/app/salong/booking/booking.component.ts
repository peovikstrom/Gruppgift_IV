import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../../data.service';
import { IShow } from '../../ishow';
import { ITicket } from '../../iticket';
import { ITicketSTUB } from '../../iticketstub';

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

  ticketIsBooked(ti: ITicket): boolean {
    // All tickets for this show
    let ti4 = this._dataService.tickets4show(this.show);
    ti4 = ti4.filter( ts => ts.seatcol === ti.seatcol && ts.seatrow === ti.seatrow);
    return ti4.length !== 0;
  }

  // Ticket from tag
  tick4tag (tag: any): ITicket {
    let ti4 = this._dataService.tickets4show(this.show);
    ti4 = ti4.filter( ts => ts.seatcol === tag.x && ts.seatrow === tag.y);
    return ti4.length > 0 ? ti4[0] : null;
  }

  dbBook() {

    let booklist: ITicket[] = [];

    if (this.tags.length <= 0) { return; }

    // Make pseudotickets for seats that may or may not be booked
    for (const tag of this.tags ) {
      const t: ITicket = <ITicket>{}; // A Cheat ticket
      t.seatcol = tag.x;
      t.seatrow = tag.y;
      t.show = this.show;
      booklist.push(t);
    }

    const seats = booklist.map ( this.ticketIsBooked, this );
    if ( seats.reduce((a, b) => a && b)) {

      // All seats booked, make tickets from tags
      booklist =  this.tags.map (this.tick4tag, this);

      this._dataService.postUnTicket(booklist).subscribe( ret => {
        this._dataService.pushGlobTickets(ret);
        // this.checkStatus(); // We got new tickets update colors
      });
    }

    if ( !seats.reduce((a, b) => a || b)) {
        this._dataService.postTicket(booklist).subscribe( ret => {
          this._dataService.pushGlobTickets(ret);
          // this.checkStatus(); // We got new tickets update colors
        });
      }
  }

  ngOnInit() {
  }

}
