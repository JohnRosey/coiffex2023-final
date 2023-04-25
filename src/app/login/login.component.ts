import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { UsersService } from '../services/users.service';
import { Router } from '@angular/router';

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
  
  //Injection du service UsersService et du Router
  constructor(public service: UsersService, public router: Router ) { }

  public login(): void {

    if(this.form.valid) {
    //Si tous les champs sont valides, on récupère les valeurs des champs
      const username = this.form.get('username')?.value;
      const password = this.form.get('password')?.value;

      const user = this.service.login(username, password);

      if (user) {
        alert('Connexion réussie ! Bienvenue ' + username + ' ');
        this.router.navigate(['/offers']);

      } else {
        alert('Connexion échouée');
      }
    }
  }
}
