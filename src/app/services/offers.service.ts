import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of, map } from 'rxjs';
import { tap } from 'rxjs/operators';

import { Offer } from '../models/Offer';

@Injectable({
  providedIn: 'root'
})
export class OffersService {

  // URL de l'API externe
  private apiURL = 'https://coiffex.store/api/offer/all'; 

  constructor(private http: HttpClient) { }

  /** Méthode permettant de récupérer la liste des offres */
  getOffersList(): Observable<Offer[]> {
    return this.http.get<Offer[]>(this.apiURL).pipe(
      tap((response) => console.table(response)),
      catchError((error) => this.handleError(error, undefined))
    );
  }

  /** Méthode permettant de récupérer une offre par son id */
  getOfferById(offerId: number): Observable<Offer> {
    return this.http.get<Offer[]>(`${this.apiURL}`).pipe(
      map((offers: any) => offers.find((offer: any) => offer.id === offerId)),
      tap((response: any) => console.log(response)),
      catchError((error) => this.handleError(error, undefined))
    );
  }
  
  /** Méthode pour la gestion d'erreur */
  private handleError(error: Error, errorValue: any) {
    console.error(error);
    return of(errorValue);
  }
}
