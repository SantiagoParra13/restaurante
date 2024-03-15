import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { CategoriaService } from 'src/app/service/categoria/categoria.service';
import { ComidaService } from 'src/app/service/comida/comida.service';

@Component({
  selector: 'app-update-comidas',
  templateUrl: './update-comidas.component.html',
  styleUrls: ['./update-comidas.component.css'],
})
export class UpdateComidasComponent implements OnInit {

  comidaId=0;
  comidaData:any;
  categoriaData: any[] = [];
  comidaForm:any;
  image:any;

  constructor(
    private route: ActivatedRoute,
    private comidaService: ComidaService,
    private fb: FormBuilder,
    private messageService: MessageService,
    private categoriaService:CategoriaService,
    private router:Router  ) {}


  ngOnInit(): void {
    this.comidaId = this.route.snapshot.params['id'];
    //traigo la comida
    this.comidaService.obtnerComida(this.comidaId).subscribe((res:any) => this.comidaData=res)
    //traigo la categoria
    this.categoriaService.listarCategorias().subscribe((res: any) => this.categoriaData = res );// Asigna todo el array de categorías
  }


  actualizarDatos(){
    this.comidaData.image = this.image;
    this.comidaService.actualizarComida(this.comidaData).subscribe(res =>{
      this.messageService.add({ severity: 'success', summary: 'Success', detail: 'Comida Actualizada Con exito' });
      setTimeout(() => {
        this.router.navigate(['/admin/view-comidas']);
      }, 500);
    }, (error) => {
      this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error al Actualizar el examen' });
    })
  
    }

    onFileChange(event: any) {
      const file = event.target.files[0];
      const reader = new FileReader();
    
      reader.onload = (e) => {
        const base64String = reader.result as string;
        this.image=base64String;
        
      };
    
      reader.readAsDataURL(file);
      console.log(reader.readAsDataURL(file))
    }
    
  }


