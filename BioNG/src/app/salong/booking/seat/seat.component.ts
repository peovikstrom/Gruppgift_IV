import { Component, OnInit, Input } from '@angular/core';
import { IShow } from '../../../ishow';
@Component({
  selector: 'app-seat',
  templateUrl: './seat.component.html',
  styleUrls: ['./seat.component.css']
})
export class SeatComponent implements OnInit {

  @Input() colx: number;
  @Input() coly: number;
  @Input() show: IShow;

  constructor() { }

  ngOnInit() {
  }


}
