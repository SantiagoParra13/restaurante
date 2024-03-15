import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarServiceService } from 'src/app/service/car/car-service.service';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';
import { LoginService } from 'src/app/service/usuario/login/login.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css'],
})
export class PerfilComponent implements OnInit {
  users: any;
  compras:any;

  constructor(
    private loginService: LoginService,
    private route: Router,
    private cartService: CarServiceService
  ) {}
  ngOnInit(): void {
    if (this.loginService.isLoggedIn()) {
      this.loginService.getCurrentUser().subscribe((res) => {
        this.users = [res];
        this.historialuser(this.users[0].id);
      });
    } else {
      this.route.navigate(['/']);
    }
    
  }

  historialuser(userid:any) {
    this.cartService.historialDelUsuario(userid).subscribe((res) => {
      this.compras=res;
      console.log(res);
    });
  }
}
