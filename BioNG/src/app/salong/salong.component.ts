import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-salong',
  template: `<div>
                  {{greetVisitor()}} in Salong {{salNum}}<br>
                  <button (click)="onClick()">Greet</button>
                  {{greeting}}
              </div>`,
  styles: [`div {
                  color: blue;
                }
            `]
})
export class SalongComponent implements OnInit {
  public salNum = 'Ett';
  public greeting = '';
  constructor() { }

  ngOnInit() {
  }
  greetVisitor() {
    return 'Welcome to the movies!';
  }

  onClick() {
    console.log('Welcome!');
    this.greeting = 'Welcome!';
  }

}
