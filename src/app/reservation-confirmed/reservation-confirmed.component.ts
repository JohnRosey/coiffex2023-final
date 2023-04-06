import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reservation-confirmed',
  templateUrl: './reservation-confirmed.component.html',
  styleUrls: ['./reservation-confirmed.component.css']
})
export class ReservationConfirmedComponent {

  public prestation: string = '';

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.prestation = this.route.snapshot.paramMap.get('prestation') || '';
  }
}
