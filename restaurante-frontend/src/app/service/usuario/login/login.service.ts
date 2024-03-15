import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../../BaseUrl';
import { CookieService } from 'ngx-cookie-service';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginStatusSubject = new Subject<boolean>();

  

  constructor(private http:HttpClient, private cookie:CookieService) { }

  generarToken(loginData:any){
   return this.http.post(`${baseUrl}/generate-token`,loginData)
  }

  loginUser(token:any){
    this.cookie.set("token", token);
  }

  obtenerUsuario() {
    const token = this.cookie.get('token');

    if (!token) {
      // No hay token en la cookie, puedes manejar esto según tu lógica
      return null;
    }

    // Realiza una solicitud al servidor para obtener la información del usuario
    return this.http.get(`${baseUrl}/actual-usuario`, {
      headers: {
        Authorization: `Bearer ${token}` // Envia el token en el encabezado de autorización
      }
    });
  }

  isLoggedIn() {
    let tokenStr = this.cookie.get('token');
    if (tokenStr == undefined || tokenStr == null || tokenStr == '') {
      return false; // No se encontró un token en el Local Storage, el usuario no ha iniciado sesión.
    }
    return true; // Se encontró un token en el Local Storage, el usuario ha iniciado sesión.
  }

  setUser(user: any) {
    this.cookie.set('user', JSON.stringify(user));
  }


  getToken() {
    return this.cookie.get('token');
  }

  logout() {
    this.cookie.delete('token');
  }

  getUser() {
    const userStr = this.cookie.get('user');
    if (userStr != null) {
      const user = JSON.parse(userStr);
      return user || {}; // Devuelve un objeto vacío si 'user' es null o undefined.
    } else {
      this.logout();
      return {}; // Devuelve un objeto vacío si no se encuentra información del usuario.
    }
  }

  // Obtiene el rol del usuario a partir de los datos almacenados en el Local Storage.
  getUserRole() {
    let user = this.getUser();
    if (user.authorities && user.authorities.length > 0) {
      return user.authorities[0].authority;
    } else {
      console.log('no tiene authoridades asignadas');
    }
  }

  getUserId(){
    let userid=this.getUser();
    if (userid.id) {
      return userid.id;
    } else {
      console.log('user no encontrado');
    }
  }

  
  // Realiza una solicitud HTTP para obtener información del usuario actual.
  getCurrentUser() {
    return this.http.get(`${baseUrl}/actual-usuario`);
  }

}
