import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { OffersComponent } from './offers/offers.component';
import { OfferDetailsComponent } from './offer-details/offer-details.component';
import { HttpClientModule } from '@angular/common/http';
import { ReservationConfirmedComponent } from './reservation-confirmed/reservation-confirmed.component';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    OffersComponent,
    OfferDetailsComponent,
    ReservationConfirmedComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
