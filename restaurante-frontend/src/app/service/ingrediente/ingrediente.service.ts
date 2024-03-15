import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../BaseUrl';

@Injectable({
  providedIn: 'root',
})
export class IngredienteService {
  constructor(private http: HttpClient) {}

  agregarIngrediente(ingrediente: any) {
    return this.http.post(`${baseUrl}/ingrediente/`, ingrediente);
  }

  ObtenerTodosLosIngredientes() {
    return this.http.get(`${baseUrl}/ingrediente/`);
  }

  listarIngredientesDeLaComida(comidaId: any) {
    return this.http.get(`${baseUrl}/ingrediente/comida/${comidaId}`);
  }

  eliminarIngrediente(ingredienteId: any) {
    return this.http.delete(`${baseUrl}/ingrediente/`, ingredienteId);
  }
}
