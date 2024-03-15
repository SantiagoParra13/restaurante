import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';

import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';

//prime
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { MessagesModule } from 'primeng/messages';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { InputTextareaModule } from 'primeng/inputtextarea';
import { InputTextModule } from 'primeng/inputtext';
import { FieldsetModule } from 'primeng/fieldset';
import { DividerModule } from 'primeng/divider';
import { DropdownModule } from 'primeng/dropdown';
import { InputNumberModule } from 'primeng/inputnumber';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { RatingModule } from 'primeng/rating';
import { InputSwitchModule } from 'primeng/inputswitch';


import { SidebarModule } from 'primeng/sidebar';
import { ButtonModule } from 'primeng/button';
import { PerfilComponent } from './perfil/perfil.component';
import { AddCategoriaComponent } from './categorias/add-categoria/add-categoria.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewCategoriaComponent } from './categorias/view-categoria/view-categoria.component';
import { AddComidaComponent } from './comidas/add-comida/add-comida.component';
import { ViewComidasComponent } from './comidas/view-comidas/view-comidas.component';
import { UpdateComidasComponent } from './comidas/update-comidas/update-comidas.component';
import { AddIngredienteComidaComponent } from './ingredientes/add-ingrediente-comida/add-ingrediente-comida.component';
import { ViewUsuariosComponent } from './usuarios/view-usuarios/view-usuarios.component';
import { ViewComprasUsuariosComponent } from './usuarios/view-compras-usuarios/view-compras-usuarios.component';
import { ContentComponent } from './content/content.component';


@NgModule({
  declarations: [
    AdminDashboardComponent,
    SidebarComponent,
    PerfilComponent,
    AddCategoriaComponent,
    ViewCategoriaComponent,
    AddComidaComponent,
    ViewComidasComponent,
    UpdateComidasComponent,
    AddIngredienteComidaComponent,
    ViewUsuariosComponent,
    ViewComprasUsuariosComponent,
    ContentComponent,

  ],
  imports: [
    CommonModule,
    SidebarModule,
    ButtonModule,
    AdminRoutingModule,
    CardModule,
    TableModule,
    MessagesModule,
    ToastModule,
    FormsModule,
    ReactiveFormsModule,
    InputTextareaModule,
    InputTextModule,
    FieldsetModule,
    DividerModule,
    DropdownModule,
    InputNumberModule,
    ConfirmDialogModule,
    RatingModule,
    InputSwitchModule
  ],
  providers:[MessageService,ConfirmationService]
  
})
export class ModuleAdminModule { }
