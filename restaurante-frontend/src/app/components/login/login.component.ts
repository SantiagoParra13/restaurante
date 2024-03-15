  import { Component, OnInit } from '@angular/core';
  import { FormBuilder, Validators } from '@angular/forms';
  import { Router } from '@angular/router';
  import { LoginService } from 'src/app/service/usuario/login/login.service';
  import { MessageService } from 'primeng/api';

  @Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
  })
  export class LoginComponent implements OnInit {

    userCurrent:any;

    visible: boolean = false;

    showDialog() {
        this.visible = true;
    }

    constructor(
      private fb: FormBuilder,
      public loginService: LoginService,
      private router: Router,
      private messageService:MessageService
    ) {}

    ngOnInit(): void {
      if(this.loginService.isLoggedIn()){
          this.userActual();
          console.log(this.userCurrent)
      }
    }

    loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });

    userActual(){
      this.userCurrent = this.loginService.getUser();
  }

  adminPerfil(){
    const userRole = this.loginService.getUserRole();
    if (userRole === 'ADMIN') {
        this.router.navigate(['/admin/perfil']);
    
      }if (userRole === 'USER'){
        this.router.navigate(['/perfil']);
      }

}

    async iniciarSesion() {
      try {
        const res:any = await this.loginService.generarToken(this.loginForm.value).toPromise();
        this.messageService.add({
          severity: 'success',
          summary: 'Éxito',
          detail: 'Inicio de sesión exitoso.',
        });
        console.log(res);
        this.loginService.loginUser(res.token); 
        const user: any = await this.loginService.obtenerUsuario()?.toPromise();
        this.loginService.setUser(user);
        console.log(user);
        const userRole = this.loginService.getUserRole();


        if (userRole === 'ADMIN') {
          setTimeout(() => {
            window.location.href = '/admin/welcome';
            this.router.navigate(['/admin/welcome']);
            this.loginForm.reset();
            this.visible = false;
          }, ); // 2000 milisegundos = 2 segundos
          this.loginService.loginStatusSubject.next(true);
        } else if (userRole === 'USER') {
          setTimeout(() => {  
            window.location.href = '/';
            this.router.navigate(['/']);
            this.loginForm.reset();
            this.visible = false;
           
          }, ); 
          this.loginService.loginStatusSubject.next(true);
        } else {
          this.loginService.logout();
        }
      } catch (error) {
        console.error('Error al iniciar sesión:', error);
        // Puedes mostrar un mensaje de error aquí si lo deseas.
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: 'Inicio de sesión fallido. Verifique sus credenciales.',
        });
      }
    }
  }
