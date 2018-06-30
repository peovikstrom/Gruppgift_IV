import { Component, OnInit, Input } from '@angular/core';
import { IShow } from '../../ishow';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  @Input() show: IShow;

  tags = [];

  constructor() { }

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

  ngOnInit() {
  }

}
