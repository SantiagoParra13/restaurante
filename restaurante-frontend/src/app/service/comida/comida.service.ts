import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../BaseUrl';

@Injectable({
  providedIn: 'root'
})
export class ComidaService {

  constructor(private http:HttpClient) { }

  addComida(comida:any){
    return this.http.post(`${baseUrl}/comida/`,comida)
  }

  listarComidas(){
    return this.http.get(`${baseUrl}/comida/`)
  }

  obtnerComida(id:any){
    return this.http.get(`${baseUrl}/comida/${id}`)
  }

  eliminarComida(comidaId:any){
    return this.http.delete(`${baseUrl}/comida/${comidaId}`)
  }

  actualizarComida(comida:any){
    return this.http.put(`${baseUrl}/comida/`,comida)

  }

  recomendada(){
    return this.http.get(`${baseUrl}/comida/best`)
  }
}
