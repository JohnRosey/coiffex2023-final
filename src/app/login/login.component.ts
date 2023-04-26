import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { UsersService } from '../services/users.service';
import { Router } from '@angular/router';
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  // Formulaire de connexion
  public form: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  constructor(public router :Router,public service: UsersService, private authservice:AuthService) { }
  
  //Injection du service UsersService et du Router

  public login(): void {

    if(this.form.valid) {
    //Si tous les champs sont valides, on récupère les valeurs des champs
      const username = this.form.get('username')?.value;
      const password = this.form.get('password')?.value;

      this.authservice.login(username,password).subscribe(data=>{
        console.log(data);
          this.router.navigate(['/offers']);
      },
      (error)=>{
        console.log(error);

      });
      }
    }
}
