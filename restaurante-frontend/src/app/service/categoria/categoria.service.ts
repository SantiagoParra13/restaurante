import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../BaseUrl';
import { retry } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http:HttpClient) { }

  addCategoria(categoria:any){
   return this.http.post(`${baseUrl}/categoria/`,categoria);
  }

  listarCategorias(){
    return this.http.get(`${baseUrl}/categoria/`)
  }

  listarComidaDeUnaCategoria(categoriaId:any){
    return this.http.get(`${baseUrl}/comida/categoria/${categoriaId}`)
  }
}
