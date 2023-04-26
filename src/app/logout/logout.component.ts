import { Component, OnInit } from '@angular/core';

import { UsersService } from '../services/users.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private usersService: UsersService) { }

  public ngOnInit(): void {
    this.logout();
  }

  public logout(): void {
    this.usersService.logout();
  }

}
