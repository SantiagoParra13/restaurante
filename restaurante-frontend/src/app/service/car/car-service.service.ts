import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { baseUrl } from '../BaseUrl';

@Injectable({
  providedIn: 'root'
})
export class CarServiceService {

  constructor(private http:HttpClient) { }

  addToCart(comidaId: any, userId: any, amount: any) {
    const data = {
      comida: {
        id: comidaId
      },
      client: {
        id: userId
      },
      amount: amount
    };
    console.log(data)
    return this.http.post(`${baseUrl}/shoppingList/`, data);
  }


  //para la notificacion de cuantos productos tengo en el carrito
  badgeCar(clientId:any){
    return this.http.get(`${baseUrl}/shoppingList/count/${clientId}`)
  }

  //poder ver todos las comidas
  listarDetallesComida(){
    return this.http.get(`${baseUrl}/shoppingList/`);
  }

  //eliminarProducto
  eliminarComida(comidaId:any){
    return this.http.delete(`${baseUrl}/shoppingList/clean/${comidaId}`)
  }

  //pagar
  pagarPedido(){
    return this.http.post(`${baseUrl}/sale/create`,null)
  }

  //compras del usaurrio
  historialDelUsuario(usuarioId:any){
    return this.http.get(`${baseUrl}/saleDetail/${usuarioId}`)
  }
}
