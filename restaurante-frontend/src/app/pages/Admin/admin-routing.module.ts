import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { PerfilComponent } from './perfil/perfil.component';
import { AddCategoriaComponent } from './categorias/add-categoria/add-categoria.component';
import { ViewCategoriaComponent } from './categorias/view-categoria/view-categoria.component';
import { AddComidaComponent } from './comidas/add-comida/add-comida.component';
import { ViewComidasComponent } from './comidas/view-comidas/view-comidas.component';
import { UpdateComidasComponent } from './comidas/update-comidas/update-comidas.component';
import { AddIngredienteComidaComponent } from './ingredientes/add-ingrediente-comida/add-ingrediente-comida.component';
import { ViewUsuariosComponent } from './usuarios/view-usuarios/view-usuarios.component';
import { ViewComprasUsuariosComponent } from './usuarios/view-compras-usuarios/view-compras-usuarios.component';
import { ContentComponent } from './content/content.component';

const routes: Routes = [
  {
    path: 'admin',component:AdminDashboardComponent,
    children: [
      { path: 'perfil', component: PerfilComponent },
      {path:'welcome',component:ContentComponent},
      {path:'categoria', component:AddCategoriaComponent},
      {path:'view-categoria',component:ViewCategoriaComponent},
      {path:'view-comidas', component:ViewComidasComponent},
      {path:'add-comida',component:AddComidaComponent},
      {path:'update-comida/:id', component:UpdateComidasComponent},
      {path:'add-ingrediente/:id/:titulo',component:AddIngredienteComidaComponent},
      {path:'view-usuarios',component:ViewUsuariosComponent},
      {path:'view-compras-user/:username',component:ViewComprasUsuariosComponent}
    ],
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AdminRoutingModule {}
