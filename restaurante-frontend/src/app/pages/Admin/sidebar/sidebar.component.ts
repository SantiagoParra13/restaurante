import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css'],
})
export class SidebarComponent implements OnInit {
  comidas: any;
  ingredientes: any;

  ngOnInit(): void {
    this.comidas = [
      { name: 'Agregar comidas', route: 'add-comida' },
      { name: 'Todas las Comidas', route: 'view-comidas' },
    ];

    this.ingredientes = [
      { name: 'Añadir Ingrediente',  },
    ];
  }
  sidebarVisible: boolean = false;
}
