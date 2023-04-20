import { Component } from '@angular/core';

import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent {

  constructor(private usersService: UsersService) { }

  public isLoggedIn(): boolean {
    return this.usersService.isLoggedIn();
  }

}
