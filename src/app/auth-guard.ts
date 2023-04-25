import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { UsersService } from './services/users.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(private userService: UsersService, private router: Router) {}

  canActivate(): boolean {
    const currentUser = this.userService.getCurrentUser();
    if (currentUser) {
      return true; // l'utilisateur est connecté, autoriser l'accès à la route
    } else {
      this.router.navigate(['/login']); // rediriger vers la page de connexion
      return false; // l'utilisateur n'est pas connecté, bloquer l'accès à la route
    }
  }
}
