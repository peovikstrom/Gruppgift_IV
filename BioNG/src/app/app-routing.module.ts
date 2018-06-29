import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SalongComponent } from './salong/salong.component';
import { BookingComponent } from './salong/booking/booking.component';
import { FilmComponent } from './film/film.component';
import { ShowComponent } from './show/show.component';

const routes: Routes = [
  {path: 'salong/:id', component: SalongComponent },
  {path: 'film', component: FilmComponent },
  {path: 'show', component: ShowComponent },
  {path: 'booking', component: BookingComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [ SalongComponent, FilmComponent, ShowComponent ];
