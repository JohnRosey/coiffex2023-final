import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { UsersService } from '../users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent
 {

  public form: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  constructor(public service: UsersService, public router: Router ) { }

  public login(): void
  {

    if(this.form.valid) 
    {
      const username = this.form.get('username')?.value;
      const password = this.form.get('password')?.value;

      const user = this.service.login(username, password);

      if (user) 
      {
        alert('Connexion réussie ! Bienvenue ' + username + ' ');
        this.router.navigate(['/offers']);

      } else {
        alert('Connexion échouée');
      }
    }
  }
}
