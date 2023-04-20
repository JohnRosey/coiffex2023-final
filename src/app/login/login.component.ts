import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import { UsersService } from '../users.service';
import { Router } from '@angular/router';
import {AuthService} from "../auth.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public form: FormGroup = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  });

  constructor(public router :Router,public service: UsersService, private authservice:AuthService) { }

  public login(): void {

    if(this.form.valid) {
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
