import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { OffersComponent } from './offers/offers.component';
import { OfferDetailsComponent } from './offer-details/offer-details.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { ReservationConfirmedComponent } from './reservation-confirmed/reservation-confirmed.component';
import { LogoutComponent } from './logout/logout.component';

import { AuthGuard } from './auth-guard';

const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'offers', component:OffersComponent},
  {path:'offers/:id', component:OfferDetailsComponent},
  {path:'register', component:RegisterComponent},

  {path:'login', component:LoginComponent}, 
  {path:'logout', component:LogoutComponent, canActivate: [AuthGuard]},

  {path: 'reservation-ok/:prestation', component:ReservationConfirmedComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
