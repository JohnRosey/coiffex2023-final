import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reservation-confirmed',
  templateUrl: './reservation-confirmed.component.html',
  styleUrls: ['./reservation-confirmed.component.css']
})
export class ReservationConfirmedComponent  implements OnInit {

  public prestation: string = '';
form: FormGroup;
  constructor(private route: ActivatedRoute,private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      date: ['', Validators.required],
      time: ['', Validators.required],
      name: ['', Validators.required],
      phone: ['', [Validators.required, Validators.pattern(/^(\+\d{1,2}\s)?\(?\d{1,4}\)?[\s.-]?\d{1,4}[\s.-]?\d{1,4}$/)]],
      email: ['', [Validators.required, Validators.email]],
    });
   }

  ngOnInit(): void {
    this.prestation = this.route.snapshot.paramMap.get('prestation') || '';
  }
  

  
  submitReservation() {
    if (this.form.valid) {
      console.log('Réservation soumise', this.form.value);
      // Ajoutez ici la logique pour soumettre les données du formulaire à votre serveur ou service
    } else {
      console.log('Formulaire invalide');
    }
  }
}
