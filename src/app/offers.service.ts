import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Injectable } from '@angular/core';
import { catchError, Observable, of, tap } from 'rxjs';
import { Offer } from './models/Offer';

@Injectable({
  providedIn: 'root'
})
export class OffersService {

  constructor(private http: HttpClient){}

  /**Methode permettant de recuper la liste des offres */

  getOffersList(): Observable<Offer[]>{
    return this.http.get<Offer[]>('api/offers').pipe(
      tap((response) => console.table(response)),
      catchError((error) => this.handleError(error,undefined))
    );
  }
  
  /**Methode permettant de recuper une offre grâce à son ID */

  getOfferById(offerId : number): Observable<Offer|undefined> {
    return this.http.get<Offer>(`api/offers/${offerId}`).pipe(
      tap((response) => console.log(response)),
      catchError((error) => this.handleError(error,undefined))
    );
  }
  
  /**Methode pour la gestion d'erreur */

  private log(response:any){
    console.table(response);
  }
  
  private handleError(error: Error, errorValue:any){
    console.error(error);
    return of(errorValue);
  }
}
