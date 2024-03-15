import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../BaseUrl';

@Injectable({
  providedIn: 'root',
})
export class UsuarioServiceService {
  constructor(private http: HttpClient) {}

  listarUsuarios() {
    return this.http.get(`${baseUrl}/usuarios/`);
  }

  actualizarUsuarios(usuario: any) {
   return this.http.put(`${baseUrl}/usuarios/`, usuario);
  }

  listarUsuaioPorId(userId:any){
    return this.http.get(`${baseUrl}/usuarios/${userId}`);
  }

  comprasUsuario(username:any){
    return this.http.get(`${baseUrl}/sale/${username}`)
  }
}
