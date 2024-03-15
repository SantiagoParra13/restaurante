import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UsuarioServiceService } from 'src/app/service/usuario/usuario-service.service';

@Component({
  selector: 'app-view-compras-usuarios',
  templateUrl: './view-compras-usuarios.component.html',
  styleUrls: ['./view-compras-usuarios.component.css']
})
export class ViewComprasUsuariosComponent implements OnInit {

  username:any
  comprasuser:any

constructor(private usuarioService:UsuarioServiceService, private route:ActivatedRoute){}

  ngOnInit(): void {
  this.username = this.route.snapshot.params['username']

  this.usuarioService.comprasUsuario(this.username).subscribe(res =>{
    this.comprasuser=res;
    console.log(this.comprasuser)
  })

  }

}
