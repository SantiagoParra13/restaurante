import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { LoginService } from 'src/app/service/usuario/login/login.service';
import { RegisterService } from 'src/app/service/usuario/register/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit{
  isLoggedIn = false;
  constructor(
    private fb: FormBuilder,
    private register: RegisterService,
    public loginService:LoginService,
    private router: Router,
    private messageService: MessageService
  ) {}
  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedIn();

  }

  registerForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
    nombre: ['', Validators.required],
    apellido: ['', Validators.required],
    email: ['', Validators.required],
  });

  visible: boolean = false;

  showDialog() {
    this.visible = true;
  }

  cerrarSesion(){
    if(this.loginService.isLoggedIn()){
      this.loginService.logout();
      console.log("logou")
      window.location.href = '/';
    }
  }

  registarUsuario() {
    this.register.registrarUsurario(this.registerForm.value).subscribe(
      (res) => {
        this.messageService.add({
          severity: 'success',
          summary: 'Success',
          detail: 'Usuario Registrado Con Exito',
        });
        setTimeout(() => {
          this.router.navigate(['/']);
          this.registerForm.reset();
          this.visible=false;
        }, 2000);
      },
      (error) => {
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: 'Error al Registrar Usuario',
        });
      }
    );
  }
}
