import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { User } from '../models/User';

import { UsersService } from '../users.service';
import {AuthService} from "../auth.service";

import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  public form: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required, Validators.minLength(2)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    accountType: new FormControl('Client', Validators.required),
    localisation: new FormControl('', [Validators.required, Validators.minLength(2)])
  });
  //Fiels of the form

  constructor( public router: Router,private authservice :AuthService) { }

  public register(): void {
    if(this.form.valid) {

      
      let newUser: User = {
        id: Math.random(), //Not optimal, will be improved with backend
        username: this.form.value.username,
        email: this.form.value.email,
        passwordHash: this.form.value.password,
        accountType: this.form.value.accountType,
        offers: [],
        reservations: []
      };
<<<<<<< src/app/register/register.component.ts

      this.authservice.register(newUser.username,newUser.email,newUser.passwordHash).subscribe(data=>{
=======
      //Create a new user with the values of the form
  
      this.service.addUser(newUser);
>>>>>>> src/app/register/register.component.ts
      alert('Inscription réussie ! Bienvenue ' + newUser.username + ' !');
      this.router.navigate(['/login']);
    },
    (error)=>{
      console.log(error);
      alert('Inscription échouée !');
    }
    );
}
}
}

