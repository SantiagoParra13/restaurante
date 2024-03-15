
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from '../../usuario/login/login.service';

@Injectable({
  providedIn: 'root'
})
export class AdminService  implements CanActivate {

  constructor(private loginService:LoginService,private router:Router) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.loginService.obtenerUsuario() && this.loginService.getUserRole() == 'ADMIN'){
      return true;
    }

    this.router.navigate(['/']);
    return false;
  }
}
