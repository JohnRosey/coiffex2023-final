import { Injectable } from '@angular/core';

import { User } from './models/User';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private users: User[];

  private currentUser: User | undefined;

  constructor() {
    this.users = [];

    const user: User = {
      id: 1,
      username: 'Bob',
      email: 'bob@bobmail.fr',
      passwordHash: "mdp",
      accountType: "user",
      offers: [], 
      reservations: []
    };

    this.addUser(user);
  }

  public addUser(newUser: User): void {
    this.users.push(newUser);
  }

  public getUsers(): User[] {
    return this.users;
  }

  public getUserById(id: number): User | undefined {
    return this.users.find(user => user.id == id);
  }

  public checkIfUserNameTaken(username: string): boolean {
    return this.users.some(user => user.username == username);
  }

  public login(username: string, password: string): User | boolean {
    const user = this.users.find(user => user.username == username);
    if (user && user.passwordHash == password) {
      this.currentUser = user;
      return user;
    }
    return false;
  }

  public getCurrentUser(): User | undefined {
    return this.currentUser;
  }
}
