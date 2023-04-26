import{HttpClient} from '@angular/common/http';
import{User} from './models/User';
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class AuthService{

  private apiUrl = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) {}
  register(username:string , email:string, password:string){
    const body ={
      username: username,
      email: email,
      password: password

    };
    return this.http.post(`${this.apiUrl}/register`, body ,{responseType: 'text' as 'json'});
  }
  login(username:string, password:string){
    const body ={
      username: username,
      password: password

    };
    return this.http.post(`${this.apiUrl}/login`, body ,{responseType: 'text' as 'json'});
  }
}
