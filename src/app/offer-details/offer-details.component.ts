import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Offer } from '../models/Offer';
import { OffersService } from '../services/offers.service';

@Component({
  selector: 'app-offer-details',
  templateUrl: './offer-details.component.html',
  styleUrls: ['./offer-details.component.css']
})
export class OfferDetailsComponent implements OnInit {

  offerList?: Offer[];
  offer?: Offer;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private offerService: OffersService ) {
  }

  ngOnInit() {

    const offerId: string|null = this.route.snapshot.paramMap.get('id');

    if(offerId) {
      this.offerService.getOfferById(+offerId)
        .subscribe(offer => this.offer = offer);
    }

  }


}
