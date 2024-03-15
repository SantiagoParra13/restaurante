import { NgModule } from '@angular/core';
import{BrowserAnimationsModule} from '@angular/platform-browser/animations'
import { BrowserModule } from '@angular/platform-browser';

//modulos
import { ModuleAdminModule } from './pages/Admin/module-admin.module';
import { UserModuleModule } from './pages/User/user-module.module';

//primeng
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { MessagesModule } from 'primeng/messages';
import { MessageService } from 'primeng/api';
import { MenubarModule } from 'primeng/menubar';
import { DialogModule } from 'primeng/dialog';
import { CardModule } from 'primeng/card';
import { TableModule } from 'primeng/table';
import { ToastModule } from 'primeng/toast';
import { InputNumberModule } from 'primeng/inputnumber';
import { DropdownModule } from 'primeng/dropdown';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { DialogService } from 'primeng/dynamicdialog';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';


//starts
import { NgxStarsModule } from 'ngx-stars';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";
import { CookieService } from 'ngx-cookie-service';
import { AuthInterceptorProviders } from './service/auth.interceptors';
import { SearchComponent } from './components/search/search.component';
import { TagsComponent } from './components/tags/tags.component';
import { NoEncontradaComponent } from './components/no-encontrada/no-encontrada.component';
import { FoodPageComponent } from './components/food-page/food-page.component';
import { CartPageComponent } from './components/cart-page/cart-page.component';
import { NoLogginComponent } from './components/no-loggin/no-loggin.component';
import { PagoComponent } from './components/pago/pago.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    NavbarComponent,
    HomeComponent,
    SearchComponent,
    TagsComponent,
    NoEncontradaComponent,
    FoodPageComponent,
    CartPageComponent,
    NoLogginComponent,
    PagoComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ModuleAdminModule,
    UserModuleModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    InputTextModule,
    ButtonModule,
    MessagesModule,
    MenubarModule,
    BrowserAnimationsModule,
    DialogModule,
    CardModule,
    TableModule,
    ToastModule,
    NgxStarsModule,
    InputNumberModule,
    DropdownModule,
    DynamicDialogModule
  ],
  providers: [CookieService,MessageService,DialogService,AuthInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
