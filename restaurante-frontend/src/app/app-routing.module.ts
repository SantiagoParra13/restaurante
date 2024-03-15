import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AdminDashboardComponent } from './pages/Admin/admin-dashboard/admin-dashboard.component';
import { AdminService } from './service/guards/admin/admin.guard';
import { UserService } from './service/guards/user/user.guard';
import { PerfilComponent } from './pages/Admin/perfil/perfil.component';
import { FoodPageComponent } from './components/food-page/food-page.component';
import { CartPageComponent } from './components/cart-page/cart-page.component';

const routes: Routes = [
  { path: '', component: HomeComponent, pathMatch: 'full' },

  {
    path: 'admin',
    component: AdminDashboardComponent,
    canActivate: [AdminService],
    loadChildren: () =>
      import('./pages/Admin/admin-routing.module').then(
        (m) => m.AdminRoutingModule
      ),
  },

  {
    path: 'home',
    component: HomeComponent,
    canActivate: [UserService],
    children: [{ path: '**', pathMatch: 'full', redirectTo: 'home' }],
  },
  { path: 'food/:id', component: FoodPageComponent },
  { path: 'search/:item', component: HomeComponent },
  { path: 'cart-page', component: CartPageComponent },
  { path: 'tag/:categoryId', component: HomeComponent },
  { path: 'perfil', component: PerfilComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
