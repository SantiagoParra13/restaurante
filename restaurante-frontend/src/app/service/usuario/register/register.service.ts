import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../../BaseUrl';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }

  registrarUsurario(user:any){
    return this.http.post(`${baseUrl}/usuarios/`,user)
  }
}
