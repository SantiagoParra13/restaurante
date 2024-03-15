import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-no-loggin',
  templateUrl: './no-loggin.component.html',
  styleUrls: ['./no-loggin.component.css']
})
export class NoLogginComponent {

  constructor(private messageService: MessageService) {}

  showError() {
    this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Primero debes registrarte o Iniciar Sesion' });
}

}
