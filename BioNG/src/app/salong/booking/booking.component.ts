import { Component, OnInit, Input } from '@angular/core';
import { IShow } from '../../ishow';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {

  @Input() show: IShow;

  constructor() { }

  ngOnInit() {
  }

}
