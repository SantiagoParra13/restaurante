import { Component, OnInit,OnDestroy } from '@angular/core';
import { MessageService } from 'primeng/api';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { CarServiceService } from 'src/app/service/car/car-service.service';
import { LoginService } from 'src/app/service/usuario/login/login.service';
import { PagoComponent } from "../pago/pago.component";
@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css'],
})
export class CartPageComponent implements OnInit {
  constructor(
    private cartService: CarServiceService,
    private messageService: MessageService,
    private loginService:LoginService,
    private dialogService:DialogService
  ) {}

  food: any;
  totalProducts: any;
  userID:any
  ref: DynamicDialogRef | undefined;

  ngOnInit(): void {
    if(!this.food){
      this.listarComidas();
      this.totalProductos();
    }
    
  }

  listarComidas() {
    this.cartService.listarDetallesComida().subscribe((res) => {
      this.food = res;    
    });
  }

  eliminarComida(comidaId: any) {
    this.cartService.eliminarComida(comidaId).subscribe((res) => {
      this.messageService.add({
        severity: 'success',
        summary: 'Success',
        detail: 'Comida Eliminada Con Exito',
      });
      this.listarComidas();
      this.totalProductos();
    });
  }

  totalProductos() {
   this.userID=this.loginService.getUserId();
    this.cartService.badgeCar(this.userID).subscribe((res: any) => {
      this.totalProducts = res;
     
    },(error => {
      console.log(error)
    })
    );
  }

  pagar(){
    this.cartService.pagarPedido().subscribe(res=>{
      console.log(res)
      this.ref = this.dialogService.open(PagoComponent, {
        header: 'Pagos',
        width: '70%',
        contentStyle: { overflow: 'auto' },
        baseZIndex: 10000,
        maximizable: true
    });

    this.ref.onClose.subscribe((food: any) => {
        if (food) {
            this.messageService.add({ severity: 'success', summary: 'Producto Pagado', detail:'Producto Pagado con exito'  });
        }
    });
    })
  }

  ngOnDestroy() {
    if (this.ref) {
        this.ref.close();
    }
}
}
