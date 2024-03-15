import { Component, OnInit } from '@angular/core';
import { UsuarioServiceService } from 'src/app/service/usuario/usuario-service.service';
import { forkJoin } from 'rxjs'; // Importar forkJoin desde RxJS

@Component({
  selector: 'app-view-usuarios',
  templateUrl: './view-usuarios.component.html',
  styleUrls: ['./view-usuarios.component.css'],
})
export class ViewUsuariosComponent implements OnInit {
  usuarios: any; // Variable para almacenar la lista de usuarios

  constructor(private usuarioService: UsuarioServiceService) {}

  ngOnInit(): void {
    // Obtener la lista de usuarios
    this.usuarioService.listarUsuarios().subscribe((res: any) => {
      this.usuarios = res as any[]; // Almacenar la lista de usuarios

      // Crear un array de observables para las solicitudes de usuarios por id
      const observables = this.usuarios.map((usuario: any) =>
        this.usuarioService.listarUsuaioPorId(usuario.id)
      );

      // Esperar a que se completen todas las solicitudes con forkJoin
      forkJoin(observables).subscribe((responses: any) => {
        // Procesar las respuestas y asignar los ids a los usuarios
        responses.forEach((res:any, index:any) => {
          const usuario = this.usuarios[index];
          if (res) {
            usuario.id = res.id;
          }
        });
      });
    });
  }
}
