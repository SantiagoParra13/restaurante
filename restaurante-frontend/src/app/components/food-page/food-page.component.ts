import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { CarServiceService } from 'src/app/service/car/car-service.service';
import { ComidaService } from 'src/app/service/comida/comida.service';
import { LoginService } from 'src/app/service/usuario/login/login.service';

@Component({
  selector: 'app-food-page',
  templateUrl: './food-page.component.html',
  styleUrls: ['./food-page.component.css'],
})
export class FoodPageComponent implements OnInit {
  food: any;
  comidaId: any;
  userId: any;
  amount: any;
  badge: any;

  carForm = this.fv.group({
    amount: [null], // Agrega un campo para la cantidad de comida
  });

  constructor(
    private activatedRoute: ActivatedRoute,
    private foodService: ComidaService,
    private userService: LoginService,
    private cartService: CarServiceService,
    private fv: FormBuilder,
    private router: Router,
    private messageService: MessageService
  ) {
    activatedRoute.params.subscribe((params: any) => {
      if (params['id']) {
        this.foodService.obtnerComida(params['id']).subscribe((res) => {
          this.food = res;
        });
      }
    });
  }

  ngOnInit(): void {
    this.comidaId = this.activatedRoute.snapshot.params['id'];
    this.userId = this.userService.getUser();

    this.amount = [0,1, 2, 3, 4, 5];

    this.notificacionCarrito();
  }

  notificacionCarrito() {
    this.cartService.badgeCar(this.userId.id).subscribe((res) => {
      this.badge = res;
      console.log(this.badge);
    });
  }

  addToCart() {
    const amount: any = this.carForm.get('amount')?.value; // Obtén la cantidad del formulario

    if (amount === null) {
      this.messageService.add({
        severity: 'info',
        summary: 'Info',
        detail: 'La cantidad debe ser mayor a Cero.',
      });
    } else {
      // La cantidad es mayor que cero, procede con la adición al carrito
      this.cartService
        .addToCart(this.comidaId, this.userId.id, amount)
        .subscribe(
          (res) => {
            this.messageService.add({
              severity: 'success',
              summary: 'Éxito',
              detail: 'Comida Agregada Exitosamente.',
            });
            console.log(res);
            this.notificacionCarrito();
          },
          (error) => {
            console.log(error);
            this.messageService.add({
              severity: 'error',
              summary: 'Error',
              detail: 'Error al agregar comida.',
            });
          }
        );
      console.log(this.comidaId, this.userId.id, amount);
      // Redirige al carrito después de agregar la comida
      // this.router.navigateByUrl('/cart-page');
    }
  }
}
