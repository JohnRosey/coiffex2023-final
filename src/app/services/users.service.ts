import { Injectable } from '@angular/core';

import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  //TODO : Connecter au backend

  // Liste des utilisateurs
  private users: User[];

  // Utilisateur courant
  private currentUser: User | undefined;

  constructor() {
    this.users = [];

    // Création d'un utilisateur de test
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

  // Ajout d'un utilisateur
  public addUser(newUser: User): void {
    this.users.push(newUser);
  }

  // Récupération de la liste des utilisateurs
  public getUsers(): User[] {
    return this.users;
  }

  // Récupération d'un utilisateur par son id
  public getUserById(id: number): User | undefined {
    return this.users.find(user => user.id == id);
  }

  // Récupération d'un utilisateur par son nom d'utilisateur
  public checkIfUserNameTaken(username: string): boolean {
    return this.users.some(user => user.username == username);
  }

  // Récupération d'un utilisateur par son email
  public login(username: string, password: string): User | boolean {
    const user = this.users.find(user => user.username == username);
    if (user && user.passwordHash == password) {
      this.currentUser = user;
      return user;
    }
    return false;
  }

  // Récupération de l'utilisateur courant
  public getCurrentUser(): User | undefined {
    return this.currentUser;
  }

  public logout(): void {
    this.currentUser = undefined;
  }

  public isLoggedIn(): boolean {
    return this.currentUser != undefined;
  }
}
