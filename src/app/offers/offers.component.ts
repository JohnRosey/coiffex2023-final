import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Offer } from '../models/Offer';
import { OffersService } from '../services/offers.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})


export class OffersComponent {
  
  offerList?: Offer[];


  constructor(
    private router: Router,
    private offerservice: OffersService)
  {}

  ngOnInit(){
    this.offerservice.getOffersList()
      .subscribe(offerList => this.offerList = offerList);
  }

}
