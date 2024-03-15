import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {
  ConfirmationService,
  MessageService,
  ConfirmEventType,
} from 'primeng/api';
import { ComidaService } from 'src/app/service/comida/comida.service';
import { IngredienteService } from 'src/app/service/ingrediente/ingrediente.service';

@Component({
  selector: 'app-view-comidas',
  templateUrl: './view-comidas.component.html',
  styleUrls: ['./view-comidas.component.css'],
})
export class ViewComidasComponent implements OnInit {
  comidas: any[] = [];
  ingrediente: any;

  constructor(
    private route: ActivatedRoute,
    private comidaService: ComidaService,
    private ingredienteService: IngredienteService,
    private confirmationService: ConfirmationService,
    private messageService: MessageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.comidaService.listarComidas().subscribe((res) => {
      this.comidas = res as any[];

      console.log(this.comidas)

      // Cargar ingredientes para cada comida
      this.comidas.forEach((comida) => {
        this.listarIngredientes(comida.id);
      });
    });
  }

 /**
 * Este método se utiliza para cargar los ingredientes asociados a una comida específica.
 *
 * @param comidaId El identificador de la comida para la cual se desean cargar los ingredientes.
 */
listarIngredientes(comidaId: any) {
  // Llama al servicio para obtener la lista de ingredientes de la comida identificada por comidaId
  this.ingredienteService.listarIngredientesDeLaComida(comidaId).subscribe((res) => {
    // Busca la comida correspondiente en la lista de comidas
    const comida = this.comidas.find((c) => c.id === comidaId);
    
    if (comida) {
      // Asigna la lista de ingredientes a la propiedad "ingredientes" del objeto comida
      comida.ingredientes = res as any[];
    }
  });
}

  eliminarComida(id: any) {
    this.confirmationService.confirm({
      message: 'Quieres eliminar esta Comida?',
      header: 'Confirmar Eliminacion',
      icon: 'pi pi-info-circle',
      accept: () => {
        this.comidaService.eliminarComida(id).subscribe(
          (res) => {
            this.comidas = this.comidas.filter(
              (comida: any) => comida.id != id
            );
            this.messageService.add({
              severity: 'success',
              summary: 'Success',
              detail: 'Se ha  Eliminado La Comida Correctamente',
            });
          },
          (error) => {
            console.error(error);
            this.messageService.add({
              severity: 'error',
              summary: 'Error',
              detail: 'Error al Eliminar Comida',
            });
          }
        );
      },
      reject: (type: ConfirmEventType) => {
        // Usa ConfirmEventType como una enumeración
        switch (type) {
          case ConfirmEventType.CANCEL:
            this.messageService.add({
              severity: 'info',
              summary: 'Cancelado',
              detail: 'Eliminacion de Comida Cancelada',
            });
            break;
        }
      },
    });
  }
}
