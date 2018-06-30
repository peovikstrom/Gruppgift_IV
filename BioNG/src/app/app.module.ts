import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { DataService } from './data.service';
import { HttpClientModule } from '@angular/common/http';
import { BookingComponent } from './salong/booking/booking.component';
import { SeatComponent } from './salong/booking/seat/seat.component';
import { CreateComponent } from './show/create/create.component';


@NgModule({
  declarations: [
    AppComponent,
    routingComponents,
    BookingComponent,
    SeatComponent,
    CreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule.forRoot()
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
